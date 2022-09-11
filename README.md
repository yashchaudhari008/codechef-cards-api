# Codechef Cards API

![Heroku](https://heroku-badge.herokuapp.com/?app=codechef-cards-api)
![GitHub repo size](https://img.shields.io/github/repo-size/yashchaudhari008/Codechef_Cards)
![GitHub](https://img.shields.io/github/license/yashchaudhari008/Codechef_Cards)

A REST API to get [codechef](https://www.codechef.com/) user details. Made using [Spring Boot](https://spring.io/projects/spring-boot) and [jsoup](https://jsoup.org/).

---

## 📩 Request Format

    https://codechef-cards-api.herokuapp.com/{username}

## 📝 Example URL

    https://codechef-cards-api.herokuapp.com/mad_008

## ✉️ Response Format

    {
        "data": {
            "username": {String},
            "name": {String},
            "isActiveUser": {Boolean},
            "rating": {Integer},
            "highestRating": {Integer},
            "stars": {Integer},
            "globalRank": {Long || null},
            "countryRank": {Long || null},
            "problemFullySolved": {Long},
            "problemPartiallySolved": {Long}
        },
        "status": "success"
    }

---

## 🖥 Apps Using This API

1. [Codechef Cards](https://yashchaudhari008.github.io/Codechef_Cards/)

## 🏃‍ Runnning Locally

Open project in IDE of your choice (IntelliJ Recommended) and execute `main` method of `CodechefCardsApiApplication.java`

> 💡 Pro Tip -
> Use this JSON Formatter Chrome Extension to view in a structured format.

## 🤝 Contributing

Check [CONTRIBUTING.md](CONTRIBUTING.md) before contributing or making a PR. 👍

- You can find issues to work on [here.](https://github.com/yashchaudhari008/codechef-cards-api/issues)
- Found a bug? or have a good suggestion [create a fresh issue here.](https://github.com/yashchaudhari008/codechef-cards-api/issues/new)

> NOTE :- For major changes, please open an issue first to discuss and then proceed further.

## 💁‍♂️ Contributors

<a href="https://github.com/yashchaudhari008/codechef-cards-api/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=yashchaudhari008/codechef-cards-api" />
</a>

Made with [contrib.rocks](https://contrib.rocks).

## 📃 License

Distributed under the MIT License. See [LICENSE](LICENSE) for more information.
