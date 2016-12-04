package org.eltoro.pact.consumer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class ContactInformationConsumerRestController {

  @Autowired
  ContractInformationClientService contractInformationClientService

  @RequestMapping(value = "/contactinformation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  Map getContactInformation(){
    contractInformationClientService.getContractInformation()?.body
  }
}
