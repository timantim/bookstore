# bookstore

## General Description
The project is a mock E-Commerce platform for book sale. It started as a school project that I wanted to develop more. Its purpose was to learn how to create an application using Java, further developed with Spring Framework, RESTful Web Services, Hibernate (with an associated MySQL database), Lombok tool, SLF4J, Caffeine Library, Hikari JDBC, and lastly - Angular2. On top of that, Winkle theme and Sufee Admin Dashboard theme have been used as to create the aesthetical aspect of the project. 

### Webapp - the store 
The e-store platform is a standalone angular project, designed to work as an interface between the client and the products. Upon completion, the client will be able to browse all the products, view pictures (and further details on a separate page), filter through the products based on various criteria, having a shopping cart which they can bring into a final checkout phase (which will require authentication). The checkout part would be a mock due to the legal aspects of integrating an online payment API on your website, albeit would be able to place an order. The store part is as of yet under progress, since the admin part was highly more important to bring to a functional phase.

### Webapp - admin
The admin side of the project is also a standalone angular project, which can only be accessed through authentication (provided the user has permission, i.e., Admin property set to true). The user will be able to view orders, marking them through different phases of completion (TODO). An interface that displays users will also be present, in which he can grant or revoke admin permissions to an user. Finally, a product component will also be accessible for basic CRUD operations on the products. A product image subcomponent will handle the addition of images and association to their respective product (partly completed). 


## Conclusion
The mock website was purely meant to learn a large extent of Angular2. Despite eventually splitting the front-end into two parts, I have also experimented with sub-projects, or modules. None of the solutions would properly allow for separate themes, hence this solution was undertaken. Proper routing played a huge part of the learning process, as well as dividing the app on modules, and using guards in order to enable authentication-access only, for the admin part. The customer checkout will work the same, once developed. Other than that, as mentioned above - CRUD operations all over, for the time being. 
