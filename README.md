<!-- PROJECT SHIELDS -->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![Quality][quality-shield]][quality-url]

<!-- PROJECT LOGO -->
<!--suppress ALL -->
<br />
<p align="center">
  <a href="https://github.com/LeoMeinel/vitalrules">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">VitalRules</h3>

  <p align="center">
    See rules on Spigot and Paper
    <br />
    <a href="https://github.com/LeoMeinel/vitalrules"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/LeoMeinel/vitalrules">View Demo</a>
    ·
    <a href="https://github.com/LeoMeinel/vitalrules/issues">Report Bug</a>
    ·
    <a href="https://github.com/LeoMeinel/vitalrules/issues">Request Feature</a>
  </p>

<!-- ABOUT THE PROJECT -->

## About The Project

### Description

VitalRules is a Plugin that gives players the ability to see server rules.

This plugin is perfect for any server wanting their players to be able to take a look at rules ingame.

### Features

- See server rules.

### Built With

- [Gradle 7](https://docs.gradle.org/7.5.1/release-notes.html)
- [OpenJDK 17](https://openjdk.java.net/projects/jdk/17/)

<!-- GETTING STARTED -->

## Getting Started

To get the plugin running on your server follow these simple steps.

### Commands and Permissions

1. Permission: `vitalrules.rules`

- Command: `/rules <page>`
- Description: See server rules

### Configuration - messages.yml

```yaml
no-perms: "&7You don't have enough permissions!"
invalid-rule: "&cInvalid rule!"
```

### Configuration - rules.yml

```yaml
1:
  - "&b&lExample Heading"
  - ""
  - "&7Example Text"
2:
  - "&b&lExample Heading 2"
  - ""
  - "&7Example Text"
```

<!-- ROADMAP -->

## Roadmap

See the [open issues](https://github.com/LeoMeinel/vitalrules/issues) for a list of proposed features (and known
issues).

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to be, learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->

## License

Distributed under the GNU General Public License v3.0. See `LICENSE` for more information.

<!-- CONTACT -->

## Contact

Leopold Meinel - [leo@meinel.dev](mailto:leo@meinel.dev) - eMail

Project Link - [VitalRules](https://github.com/LeoMeinel/vitalrules) - GitHub

<!-- ACKNOWLEDGEMENTS -->

### Acknowledgements

- [README.md - othneildrew](https://github.com/othneildrew/Best-README-Template)

<!-- MARKDOWN LINKS & IMAGES -->

[contributors-shield]: https://img.shields.io/github/contributors-anon/LeoMeinel/vitalrules?style=for-the-badge
[contributors-url]: https://github.com/LeoMeinel/vitalrules/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/LeoMeinel/vitalrules?label=Forks&style=for-the-badge
[forks-url]: https://github.com/LeoMeinel/vitalrules/network/members
[stars-shield]: https://img.shields.io/github/stars/LeoMeinel/vitalrules?style=for-the-badge
[stars-url]: https://github.com/LeoMeinel/vitalrules/stargazers
[issues-shield]: https://img.shields.io/github/issues/LeoMeinel/vitalrules?style=for-the-badge
[issues-url]: https://github.com/LeoMeinel/vitalrules/issues
[license-shield]: https://img.shields.io/github/license/LeoMeinel/vitalrules?style=for-the-badge
[license-url]: https://github.com/LeoMeinel/vitalrules/blob/main/LICENSE
[quality-shield]: https://img.shields.io/codefactor/grade/github/LeoMeinel/vitalrules?style=for-the-badge
[quality-url]: https://www.codefactor.io/repository/github/LeoMeinel/vitalrules
