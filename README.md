# stickyburp

<div align="center">

<img src="public/images/stickyburp.png" width="200" height="200" align="center" style="margin-right: 12px"/>

_Sticky Burp, Reusable and Replacable Environment Variables_
.. Use native burp notes, no more `notes.txt`! 🤙

[![GitHub release (latest by date)](https://img.shields.io/github/v/release/GangGreenTemperTatum/stickyburp)](https://github.com/GangGreenTemperTatum/stickyburp/releases)
[![GitHub stars](https://img.shields.io/github/stars/GangGreenTemperTatum/stickyburp?style=social)](https://github.com/GangGreenTemperTatum/stickyburp/stargazers)
[![BApp Store Status](https://img.shields.io/badge/BApp%20Store%20Status-Published!-green?link=https%3A%2F%2Fportswigger.net%2Fbappstore%2Fa1d3ab3c46834b60b8c95ecdb481d8c7)](https://portswigger.net/bappstore/a1d3ab3c46834b60b8c95ecdb481d8c7)
[![License](https://img.shields.io/github/license/GangGreenTemperTatum/stickyburp?branch=main)](https://github.com/GangGreenTemperTatum/stickyburp/blob/main/LICENSE)

[Report Bug](https://github.com/GangGreenTemperTatum/stickyburp/issues) •
[Request Feature](https://github.com/GangGreenTemperTatum/stickyburp/issues)

> **Note**
> StickyBurp is now available via the bAPP store! 🥳

<br>
<br>

</div>

StickyBurp is a Burp Suite extension that allows you to create and manage "stickies" (aka Global per-project Environment Variables) from highlighted/selected text across different Burp Suite tabs (think of this extension as the same functionality you get in an API testing and development tool to store variables with raw values that can be used across different views).

This functionality gives you the power to easily store variables in a table and then replace existing payload contents with these variables (ie, in the Repeater or Intruder tab). Common example use-cases for storing and replacing are:

- Exploit Server URL / Collaborator URL
- Authentication tokens/cookies (ie similar to manually testing autorize)
- UUIDs, user accounts, emails/PII etc.
- Dynamically created content from an application's response
  - IE `SECRET_TOKEN` values (see lab [Lab: Exploiting PHP deserialization with a pre-built gadget chain](https://portswigger.net/web-security/deserialization/exploiting/lab-deserialization-exploiting-php-deserialization-with-a-pre-built-gadget-chain))

Simply highlight the payload content, right-click and either add, update or replace: (_skip to the [demo](./README.md#demo) usage_)

![stickyburp intro](public/images/stickyburp-intro-readme-usage.png)

![stickyburp intro 2](public/images/stickyburp-intro-readme-usage-2.png)
*stickyburp simple use-cases!*

---

# ToC

- [stickyburp](#stickyburp)
- [ToC](#toc)
  - [Features](#features)
  - [Demo](#demo)
  - [Screenshots](#screenshots)
    - [Proxy Tab Usage](#proxy-tab-usage)
    - [Repeater Tab Usage](#repeater-tab-usage)
    - [Stickies Tab Colorized Default](#stickies-tab-colorized-default)
    - [Stickies Tab Colorized Custom](#stickies-tab-colorized-custom)
    - [Stickies Tab Sorting Functionality](#stickies-tab-sorting-functionality)
  - [Building](#building)
    - [Prerequisites](#prerequisites)
    - [Build Steps (from source)](#build-steps-from-source)
  - [Installation / Loading the extension](#installation--loading-the-extension)
    - [bAPP Store (easiest)](#bapp-store-easiest)
    - [From Source](#from-source)
  - [Usage](#usage)
  - [Contributing and Supporting](#contributing-and-supporting)
    - [Star History](#star-history)
  - [Development](#development)

## Features

- **Sticky Management**
  - Create and store stickies (AKA global environment variables) from any selected text in Burp Suite request/response panes
  - Stickies store name, value, source information and your own notes
  - Replace the values in Repeater tab with the raw value of the previously saved sticky
  - Copy stickies values to clipboard with right-click
  - Stickies can be colored for easier visibility and are by default colored
  - Stickies are persisted across projects even when burp is quit and reopened

- **Context Menu Integration**
  - Right-click selected text to create new stickies
  - Quick access to update existing stickies
  - Source tracking shows which HTTP request the stickies came from
  - Works in Burp tools for both HTTP Requests and Responses (Proxy, Repeater, Target (Site Map) etc.)

- **Dedicated UI Tab**
  - Table view of all stored stickies
  - Shows stickies name, value, source and your notes

- **Hotkeys/Shortcuts** (**No more clicks!**)
  - Automatically switch to the StickyBurp tab using "`CMD`"("`Control`" for Windows users)+"`Shift`"+"`S`"
  - Invoke the keys "`CMD`"("`Control`" for Windows users)+"`Shift`"+"`A`" to add a new Sticky

## Demo

![stickyburp publishing](./public/burp-publish-example.gif)
*stickyburp in the ginandjuiceshop! https://x.com/BApp_Store/status/1907776363974590626*

![stickyburp v1.0.0 in action](public/gifs/stickyburp.gif)
*stickyburp in action!*

![stickyburp hotkeys demo](public/gifs/stickyburp-hotkey.gif)
*stickyburp hotkeys demo*

## Screenshots

### Proxy Tab Usage
![stickyburp in Proxy](public/images/stickyburp-proxy.png)
*Selecting and storing stickies from the Proxy tab*

### Repeater Tab Usage
![stickyburp in Repeater](public/images/stickyburp-repeater.png)
*Using stored stickies in Repeater requests*

![stickyburp Variable Replacement](public/images/stickyburp-repeater-2.png)
*Quick stickies replacement in action*

### Stickies Tab Colorized Default
![stickyburp table default coloring](public/images/stickyburp-tab-default-color-v1.3.png)
*Default Stickies Coloring*

### Stickies Tab Colorized Custom
![stickyburp coloring](public/images/stickyburp-tab-colorpicker-v1.3.png)
*Custom Stickies Coloring*

### Stickies Tab Sorting Functionality
![stickyburp tabs sorted](public/images/stickyburp-table-sorting-v1.3.png)
*stickyburp tabs sorted*

---

## Building

### Prerequisites

- JDK 21 or lower
- Gradle (included via wrapper)

### Build Steps (from source)

1. Clone the repository:
```bash
git clone https://github.com/yourusername/stickyburp.git
cd stickyburp
```

2. Build the extension:
```bash
./gradlew shadowJar
```

The compiled extension JAR will be available at:
```bash
build/libs/stickyburp-all.jar
```

---

## Installation / Loading the extension

### bAPP Store (easiest)

- bAPP Store Entry -> https://portswigger.net/bappstore/a1d3ab3c46834b60b8c95ecdb481d8c7
- PortSwigger Fork -> https://github.com/portswigger/sticky-burp

<br>

![bAPP Store Install](./public/images/bAPP-store-install.png)

### From Source

1. Open Burp Suite
2. Go to Extensions tab
3. Click "Add" button
4. Select "Extension type" as Java
5. Click "Select file" and choose `build/libs/stickyburp-all.jar`
6. Click "Next" to load the extension

---

## Usage

1. **Creating Stickies**:
   - Select any text in Burp Suite (Proxy, Repeater, etc.)
   - Right-click and choose "Add to stickyburp"
   - Enter a name for your variable
   - The variable will appear in the stickyburp tab

2. **Using Stickies**:
   - Go to the stickyburp tab to view all stored stickies
   - Click on a variable to copy its value
   - Use copied values in any Burp Suite tool (Repeater, Intruder, etc.)
   - Use quick replace to swap values in requests

3. **Managing Stickies**:
   - View all stickies in the table
   - See the source of each variable
   - Copy values directly from the table
   - Add new stickies manually if needed

---

## Contributing and Supporting
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

<br>

[![GitHub stars](https://img.shields.io/github/stars/GangGreenTemperTatum/stickyburp.svg?style=social&label=Star&maxAge=2592000)](https://github.com/GangGreenTemperTatum/stickyburp/stargazers/)

### Star History

[![Star History Chart](https://api.star-history.com/svg?repos=GangGreenTemperTatum/stickyburp&type=Date)](https://star-history.com/#GangGreenTemperTatum/stickyburp&Date)

---

## Development

Core Functionality:
- `StickyVariable.kt`: Data class representing variables with name, value, and source
- `StickyBurpTab.kt`: Main UI component managing the variable table and operations
- `StickyBurpContextMenu.kt`: Context menu integration for variable operations
- `StickyBurpHttpHandler.kt`: HTTP request/response handler for variable replacement
- `StickyBurpExtension.kt`: Main extension entry point and initialization

Want to contribute? Check out our [feature request template](/.github/ISSUE_TEMPLATE/feature_request.md) for ideas or to propose new functionality!

The project uses Gradle with Kotlin for building and testing.