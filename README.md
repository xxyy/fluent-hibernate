# fluent-hibernate
A library to work with Hibernate by fluent API.

The download link:
[fluent-hibernate-0.1.0.jar](https://github.com/v-ladynev/fluent-hibernate/releases/download/v0.1.0/fluent-hibernate-0.1.0.jar)

This library hasn't dependences except Hibernate dependences. It requires Java 1.6 and above.

## Examples
Get all users.

```Java
List<User> users = H.<User> request(User.class).list();
```

Getting user with login "my_login".

```Java
final String loginToFind = "my_login";
User user = H.<User> request(User.class).eq("login", loginToFind).first();
```

You can find other examples in [fluent-hibernate-mysql project](https://github.com/v-ladynev/fluent-hibernate-mysql)

## Contributors

[V.Ladynev](https://plus.google.com/102177768964957793539/posts) and [DoubleF1re](https://github.com/DoubleF1re)

## TODO
- [ ] Refactor custom transformer, add builder
- [ ] Add gradle building system
- [ ] Consider changing API for H.update("delete from User").execute();
- [ ] In testing environment https://discuss.gradle.org/t/how-to-get-multiple-versions-of-the-same-library/7400/2