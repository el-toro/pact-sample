package org.eltoro.pact.consumer

import au.com.dius.pact.consumer.PactVerified$
import au.com.dius.pact.consumer.VerificationResult
import au.com.dius.pact.consumer.groovy.PactBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = ContractInformationClientService)
class ContractInformationClientServiceTest extends Specification {

  @Autowired
  ContractInformationClientService contractInformationClientService

  def "Pact with ContractInformationService"() {

    def contactInformationPactService = new PactBuilder()
    given:
    def stubPort = 5555
    def id = "1234"
    contractInformationClientService.providerUrl = "http://localhost:$stubPort"
    contactInformationPactService {
      serviceConsumer("Consumer")
      hasPactWith("Contact Information Provider")
      uponReceiving("a contract information retrieval request")
      port(stubPort)
      withAttributes([method: 'GET', path: "/contactinformation/$id"])
      willRespondWith(
          status: 200,
          headers: ['Content-Type': 'application/json;charset=UTF-8'],
          body: [
              lastName : "Dampf",
              firstName: "Hans"
          ])
    }

    when:
    VerificationResult result = contactInformationPactService.run {
      def responseEntity = contractInformationClientService.getContractInformation(id)

      assert responseEntity.statusCode == HttpStatus.OK
      assert responseEntity.headers.containsKey(HttpHeaders.CONTENT_TYPE)
      assert responseEntity.headers[HttpHeaders.CONTENT_TYPE].first().contains(MediaType.APPLICATION_JSON_VALUE)

      assert responseEntity.body == [lastName: "Dampf", firstName: "Hans"]
    }

    then:
    result == PactVerified$.MODULE$
  }
}
