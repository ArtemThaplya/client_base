**Приложение запускаeтся через:  mvn spring-boot:run**
##
Все допустимые символы, которые можно использовать в URI определен в RFC 3986 и могут содержать любой из следующих 84 символов:
~~~
ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-._~:/?#[]@!$&'()*+,;=
~~~
Любой другой символ должен быть закодирован с помощью процентного кодирования ( %hh).
##
Этот URL-адрес недопустим:
~~~
http://localhost:8080/shop/product?nameFilter=^E.*$
~~~
Таким образом, кодирование должно проходить на стороне клиента, и выглядеть в током формате.

**Запрос:**
~~~
http://localhost:8080/shop/product?nameFilter=%5EE.*%24
~~~

**Ответ:**
~~~
{
    "id":1,"name":"eva",
    "description":"description"
},
{
    "id":3,"name":"evaaaaa",
    "description":"description"
},
{
    "id":4,"name":"artem",
    "description":"description"
}
~~~
