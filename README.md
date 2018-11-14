"# refactorizacionEjemplo" 

Para incluir la libreria adicional en el repositorio local, hacer:
mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=sportalclientesweb-1.19.0.jar -DgroupId=SPortalClientesWeb -DartifactId=clienteSPortalClientesWeb -Dversion=1.18 -Dpackaging=jar -DlocalRepositoryPath=path\to\repository