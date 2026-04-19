# Android App
*Demo Version*

---

## Overview
This is the repository for **Pay to Drive** android **demo** application. This app aims to provide a convenient way for users to manage their London Road User charging accounts, pay for driving, and handle penalties.

> **Note:** This is a work-in-progress. Expect some features to be missing and potential software bugs.

---

## Features
- [x] **User Authentication:** Sign in to existing accounts.
- [x] **Multi-language Support:** Currently supports English and Russian.
- [x] **Compose UI:** Built with Jetpack Compose and Material 3.
- [ ] **Additional Screens:** Create Account, Settings
- [ ] **Proper API Support**: Use functioning url for http calls

---

## Tech Stack & Libraries
- **Language:** [Kotlin](https://kotlinlang.org/)
- **Android API:** 26+ (Android 8.0+)
- **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose) with **Material 3**
- **Architecture:** MVVM (Model-View-ViewModel)
- **Navigation:** [Compose Navigation](https://developer.android.com/jetpack/compose/navigation)
- **Asynchronous Logic:** [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [Flow](https://kotlinlang.org/docs/flow.html)

---

## Running from source
1. **Clone the repository:**
   ```bash
   git clone https://github.com/kolesillia/drive-app-demo.git
   ```
2. **Open the project:**
   Open Android Studio and select **File > Open**, then navigate to the cloned directory.
3. **Sync Gradle:**
   Wait for Android Studio to finish syncing the Gradle files.
4. **Run the app:**
   Select your device or emulator (API 26+) and click the **Run** button.

---

## Project Structure
- `model/`: Data classes and network response models (e.g., `SignInResponse`).
- `view/theme/`: Compose theme definitions (Colors, Typography, Themes).
- `res/`: Android resources including localized strings.

---

## License
*Add license information here (e.g., MIT, Apache 2.0)*
