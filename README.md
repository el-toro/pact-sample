# pact-sample
Simple sample project for the use of <a href="https://docs.pact.io/">Pact</a>

- Spring Boot application providing contact information
- other Spring Boot application consuming contact information via synchronous HTTP call

- Step 1: create Pact file by running *ContractInformationClientServiceTest*
- Step 2: verify the pact by running *pactVerify* on provider side (Contact Information Spring Boot app must be started manually)  
- Step 3: try out behaviour after changing consumer expectations and/or provider response
