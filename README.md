# To-Do List App

## Setting up the Backend Server 

+ **MySQL database**

	``` Database will be created automatically upon running of project

+ **Specify OAuth2 Provider ClientId's and ClientSecrets**
	
	``` For testing purposes on localhost

	```yml
    security:
      oauth2:
        client:
          registration:
            google:
              clientId: <GOOGLE_CLIENT_ID>
              clientSecret: <GOOGLE_CLIENT_SECRET>
              redirectUriTemplate: "{baseUrl}/oauth2/callback/{registrationId}"
              scope:
                - email
                - profile
            facebook:
              clientId: <FACEBOOK_CLIENT_ID>
              clientSecret: <FACEBOOK_CLIENT_SECRET>
              redirectUriTemplate: "{baseUrl}/oauth2/callback/{registrationId}"
              scope:
                - email
                - public_profile
            github:
              clientId: <GITHUB_CLIENT_ID>
              clientSecret: <GITHUB_CLIENT_SECRET>
              redirectUriTemplate: "{baseUrl}/oauth2/callback/{registrationId}"
              scope:
                - user:email
                - read:user
          provider:
            facebook:
              authorizationUri: https://www.facebook.com/v3.0/dialog/oauth
              tokenUri: https://graph.facebook.com/v3.0/oauth/access_token
              userInfoUri: https://graph.facebook.com/v3.0/me?fields=id,first_name,middle_name,last_name,name,email,verified,is_verified,picture.width(250).height(250)
	
	
** Instructions for running/building the app**
1) Import project as Maven project/ or pom.xml to desired development environment
2) Build the project and run

** Instructions for testing the app**
1) Open postman and create a new soap request.
2) enter localhost:port/To-Do
3) create POST method using raw json format.
	{
	"title": "Example testing",
	"description": "Testing",
	"scheduledon": "2022-01-01 13:0:00"
	}
4) To retrieve simply call API method using the GET method
	
	
	
	

	
