# Workout Manager

Workout Manager is a mobile application for Android developed to help users manage their strength training workouts. With this application, users can easily create, list, update, and delete workouts and exercises in a user-friendly and intuitive way.

## How to Use

To use Workout Manager, follow these simple steps:

1. **Installation:**
   - Clone this repository: `git clone https://github.com/Deivison-Costa/workout-manager.git`
   - Open the project in Android Studio.
   - Connect an Android device or start an emulator.

2. **Firebase Setup:**
   - Create a project in the [Firebase Console](https://console.firebase.google.com/).
   - Add the Android app to your Firebase project following the instructions.
   - Download the `google-services.json` file and add it to the `app` directory of your Android project.

3. **Execution:**
   - Run the application in Android Studio by pressing the "Run" button or executing `./gradlew installDebug` in the terminal.
   - The application will be installed on the device/emulator and ready for use.

4. **User Authentication:**
   - On the home screen, you will be prompted to log in or register a new account.
   - After logging in or registering, you will have access to the application's functionalities.

5. **Workout and Exercise Management:**
   - On the main screen, you will see a list of workouts.
   - You can add a new workout by tapping the add (+) button in the bottom right corner.
   - You can view details of a workout by tapping on it in the list.
   - On the workout details screen, you can add, edit, or delete exercises related to that workout.

## Architecture and Layers

The Workout Manager application follows an MVVM (Model-View-ViewModel) architecture for separation of concerns and scalability. The layers of the application include:

- **Model:** Contains the model classes representing the application data, such as `Training` and `Exercise`.
- **View:** Responsible for displaying the user interface, including the activities and fragments of the application.
- **ViewModel:** Responsible for presentation logic and interaction between the model and the view.
- **Repository:** Provides an abstraction layer over the data source, enabling integration with Firebase Firestore and Storage.
- **Firebase:** Used for user authentication, data storage (Firestore), and image storage (Firebase Storage).

## Technology Stack

- **Programming Language:** Java
- **SDK:** Android SDK
- **Database:** Firebase Firestore
- **Image Storage:** Firebase Storage
- **User Authentication:** Firebase Authentication
- **Architecture:** MVVM (Model-View-ViewModel)
- **Design Pattern:** Repository Pattern
- **User Interface:** Android Material Design
