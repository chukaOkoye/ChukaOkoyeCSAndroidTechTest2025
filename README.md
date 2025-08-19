# Chuka Okoye CS Tech Submission

## How to run
- Have all dependencies synced in the `libs.versions.toml` and `build.gradle.kts` file.
- Click RUN

## Tech used
- Kotlin/Jetpack Compose
- Retrofit/OKHttp for API
- MVVM
- Coroutines
- Hilt
- Mockito
- JUnit

## My Approach
- Built this project using the MVVM architecture pattern and using Hilt for dependency injection, to promote separation of concerns, testability and scalability.
- **Model** - Contains data models (CreditScore, CreditReportInfo) and handles data operations through a Repository abstraction.
- **ViewModel** - CreditScoreViewModel manages UI state, business logic, and interacts with the repository. It exposes the state as StateFlow for Compose to observe.
- **View (UI)** - Composables like MainScreen, ScoreScreen, and ErrorScreen render UI based on the current uiState. Used Jetpack Compose Animation to animate the score progress line to make it dynamic once loaded.
- Also includes navigation to dynamically switch between UI states such as Loading, Error, and Success using Jetpack Compose Navigation, allowing for a clean separation of concerns and improved user experience.
- Decided to use a data mapper to determine the colour of the UI credit score and progress line depending on the value for cleaner UI logic as opposed to calculating in the view model.
- Both the repository and the viewmodel are tested using JUnit and Mockito to confirm that the code is working correctly.



## Future implementations
- Included all the elements of the API response model to demonstrate how the app can be expanded if decisions call potential future features, like the change in score or financial coaching items.
- Potential database implementation to cache and store the responses to still work whilst offline.

## Screenshot
<img width="489" height="821" alt="Screenshot 2025-08-19 at 14 23 09" src="https://github.com/user-attachments/assets/6797e5a5-a376-41f0-8f0f-e339e9b6ef4e" />

## App Structure
```sh
App
│
├── Data Layer
│   ├── api/ --> Retrofit API interface (e.g. ApiService)
│   ├── model/ --> Data models / DTOs (e.g. CreditScore)
│   └── repository/ --> Repository implementation (e.g. CreditScoreRepositoryImpl)
│
├── DI
│   └── app module/ --> Hilt dependency injection base for Application
|
├── Domain Layer
│   └── repository/ --> Business logic (if using Clean Architecture)
|
└── UI Layer
│   └── screens/ --> Composables for main screen, error screen and loading screen
│   ├── mapper/ --> Data mapper for transforming objects (e.g. CreditScoreMapper)
│   ├── model/ --> UI States and model (e.g. CreditScoreUIState)
│   ├── viewmodel/ --> ViewModel for CreditScoreViewModel
│   ├── nav/ --> Navigation host and routes
|
└── MainActivity.kt --> Entry point of the app
```
