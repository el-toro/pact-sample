package org.eltoro.pact.consumer

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestOperations
import org.springframework.web.client.RestTemplate

@Service
class ContractInformationClientService {

  @Value('${providerUrl}')
  String providerUrl

  RestOperations restOperations = new RestTemplate()

  ResponseEntity getContractInformation(){
    restOperations.getForEntity("$providerUrl/contactinformation", Map)
  }
}
