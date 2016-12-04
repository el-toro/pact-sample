package org.eltoro.pact.provider

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class ContactInformationRestController {

  @RequestMapping(value = "/contactinformation/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  Map getContractInformation(@PathVariable String id) {
    [
        lastName : "Dampf",
        firstName: "Hans",
        email    : "me@example.com"
    ]
  }
}
