API_URL=http://api.emaile2e.com/v2/api-docs

commit:
	git add -A . & git commit -m 'deploy' && git push

update:
	swagger-codegen generate --lang=java \
		-DgroupId=com.api.emaile2e \
		-DartifactId=javaclient\
		-DartifactVersion=1.0.0-SNAPSHOT\
   	-DlicenseName=ISC\
		-DdeveloperName=emaile2e\
		-DdeveloperEmail=dev@emaile2e.com\
		-DdeveloperOrganization=emaile2e\
		-DdeveloperOrganizationUrl=http://emaile2e.com\
		-DartifactDescription="The official Java client for the Emaile2e API. See https://emaile2e.com for more information."\
		-i $(API_URL) -o .

deploy:
	
