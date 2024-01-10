# java_JSP_Servlets
## Un Servlet 
- c'est un programme Java exécuté sur un seveur 

## les etapes pour creer une servlet : 

- ajouter le packaging des le fichier pom.xml 

``` <packaging>war</packaging> ``` 

- ajouter les dependencies 

javax 
     <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
       
- ajouter les plugins 
jetty 

   ``` 
   <build>
        <plugins>
            <plugin>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-maven-plugin</artifactId>
                <version>9.4.35.v20201120</version>

            </plugin>
        </plugins>
    </build> 
    
    ```




