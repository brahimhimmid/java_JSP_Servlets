# java_JSP_Servlets

# Objectifs du module
• Compréhension des architectures Modèle Vue Contrôleur (MVC)
• Maîtrise de développement et de la maintenance d’IHM pour les architectures clients lourds et clients légers.
# Les demandes du monde professionnel
• Spring MVC / Struts
• Java EE
## Un Servlet 
- c'est un programme Java exécuté sur un seveur 

## les etapes pour creer une servlet : 

- ajouter le packaging des le fichier pom.xml 

``` <packaging>war</packaging> ``` 

- ajouter les dependencies 

javax 
   <dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>6.0.0</version>
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

- Déclarer notre servlet : 

 ```  @WebServlet(name = "firstServlet", urlPatterns = "/first") ``` 

apres lancer le serveur avec le plugin jetty 
et ecrire dans le navigateur web http://localhost:8080


                            OU
creer 

un dossier "webapp" dans le main 
creer le fichier web.xml ==>  file > projet structure > Facets > web > + 

### le contenu de fichier web xml à ajouter 

```<servlet>
        <servlet-name>first_servlet</servlet-name>
        <servlet-class>servlets.PremiereServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>first_servlet</servlet-name>
        <url-pattern>/second</url-pattern>
    </servlet-mapping>
    ```






