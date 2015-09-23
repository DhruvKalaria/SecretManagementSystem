# SecretManagementSystem
Secret Management System primarily provides Secret Key Lifecycle Management Service which is used by application for encrypting important data.
Also, on top of Key Lifecycle it also provides various Cryptographic operations and Pseudo Random numbers.
It is based on JCA - Java Cryptographic Architecture and provider of the cryptographic operations is Sun.

Following Responsibilities are taken care by the SMS Engine - 
1. KMS - Key Lifecycle Management with which you can Suspend Key, Expire Key, Activate Key.

2. Crypto - Cryptographic Operations implementation like:
-Digital Signatures
-Message Digests/Hash
-Certificates and Certificates Validation
-Symmetric Key Encryption
-Asymetric Key Encryption
-Key Generation and Management
-Secure Random Number Generation
-File based Encryption
-Web Tokens Generation and Verification

Future Scopes:
Auto key renewal and Key Ignition to the Distributed Cache like Hazelcast, EH Cache or Redis.
