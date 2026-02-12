# TFL Android App
*Demo Version*

---

## Overview
This is the repository for **TFL: Pay to Drive** android **demo** application. This app aims to provide a convenient way for users to manage their London Road User charging accounts, pay for driving, and handle penalties.

> **Note:** This is a work-in-progress. Expect some features to be missing and potential software bugs.

---

## Features
- **User Authentication:** Sign in to existing accounts or create a new London Road User charging account.
- **Drive Payments:** Easily pay to drive in regulated zones.
- **Penalty Management:** Check and pay for any outstanding penalties.
- **Multi-language Support:** Currently supports English and Russian.
- **Modern UI:** Built with Jetpack Compose and Material 3 for a fluid user experience.

---

## Tech Stack & Libraries
- **Language:** [Kotlin](https://kotlinlang.org/)
- **Android API:** 26+ (Android 8.0+)
- **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose) with **Material 3**
- **Architecture:** MVVM (Model-View-ViewModel)
- **Navigation:** [Compose Navigation](https://developer.android.com/jetpack/compose/navigation)
- **Asynchronous Logic:** [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [Flow](https://kotlinlang.org/docs/flow.html)

---

## Building from source
1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/TFL-Android-App.git
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
