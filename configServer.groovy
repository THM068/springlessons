// File: server.groovy
@DependencyManagementBom('org.springframework.cloud:spring-cloud-starter-parent:Brixton.M4')
@Grab('spring-cloud-config-server')
import org.springframework.cloud.config.server.EnableConfigServer
 
 @EnableConfigServer
 class ConfigServer {}

