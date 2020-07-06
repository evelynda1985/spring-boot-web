# spring-boot-web
Spring MVC

Tools used: Intellij, spring boot, spring MVC, Maven, css, thymeleaf

Anottations used:
@SpringBootApplication: Configuration class, triggers auto-configuration
@EnableAutoConfiguration: para habilitar la configuración automática
@Controller: Configura esta clase como un componente de spring de tipo controlador
 @RequestMapping: para colocar el path al que se va hacer el llamado
@GetMapping: Es el request mapping de tipo post para GET
@ModelAttribute: Queremos poblar los dropdowns, y ademas se puede usar de manera general para todos los requests, para poblar basicamente
@RequestParam: poder enviar parametros por medio de la URL
@PathVariable: For sending variables in the path
@Value: Inyectar valores en el controlador desde el archivo de properties

Project description:
Created a MVC project using spring boot. This projects contains list of users, send data through the URI, redirect and forward to others pages, send infomration using .properties file.

