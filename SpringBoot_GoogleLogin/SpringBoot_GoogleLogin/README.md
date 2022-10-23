## SpringBoot - Google Login Oauth 2.0
1. google.console.com
   Apis & Credential -> Create an Oauth Client ID
   CustomID : 155720770869-mo7mca5tcjc1h0t89ah7f8cnnggkgf4t.apps.googleusercontent.com
   Custom Secret code : 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

2. URIs
- Allowed JavaScript origins : http://localhost:8080
- Allowed redirect URIs : http://localhost:8080/login/oauth2/code/google

3. Dependencies
- Spring web
- OAuth2 Client