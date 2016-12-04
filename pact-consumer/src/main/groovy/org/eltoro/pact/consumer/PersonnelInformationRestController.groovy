package org.eltoro.pact.consumer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonnelInformationRestController {

  @Autowired
  ContractInformationClientService contractInformationClientService

  @RequestMapping(value = "/personnelinformation/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  Map getPersonnelInformation(@PathVariable String id){
    contractInformationClientService.getContractInformation(id)?.body
    // requests to other downstream services here ...
  }
}
