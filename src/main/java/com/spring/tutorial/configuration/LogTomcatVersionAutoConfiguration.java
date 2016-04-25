package com.spring.tutorial.configurationcom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by thandomafela on 22/04/2016.
 */
@Configuration
@ConditionalOnClass(ServerProperties.Tomcat.class)
@ConditionalOnProperty(name="log-tomcat-version", matchIfMissing=true)
public class LogTomcatVersionAutoConfiguration {

    private static Log logger;

    static {
        logger = LogFactory.getLog(LogTomcatVersionAutoConfiguration.class);
    }

    @PostConstruct
    public void logTomcatVersion() {
        logger.info("\n\n\nTocat v-thando: " + ServerProperties.Tomcat.class.getPackage().getImplementationVersion() +  "\n\n")
;    }
}
