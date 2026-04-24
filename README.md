# MedBoard

Android revision app for internal-medicine board exams.

Written in Kotlin + Jetpack Compose + Material 3. minSdk 26, targetSdk 34.

## Design brief

Modern, card-based UI with:
- Specialty grid home screen with a status chip per specialty (Ready / Coming soon).
- Topic detail screen that renders structured content: section headings, paragraphs, bullet / numbered lists, tables with sticky headers, callouts (Pearl / Warning / Pitfall / Exam tip), a **Board pearls** card, and a **Rapid Q&A** card with tap-to-reveal answers.
- Global topic search.
- Dedicated About & disclaimer screen explaining the content policy.

## Content policy (important)

Every topic in this app is written **in the authors' own words** as an original concise revision summary. Harrison's Principles of Internal Medicine (21st ed.) and Davidson's Principles and Practice of Medicine (24th ed.) are cited as the source texts that were studied, but **no text, table, or figure** from those books has been copied into the app.

Contributors MUST follow the same policy — do not paste from the textbooks. Instead, read the referenced chapters and write an original summary in your own words, then cite the chapter in `TopicReference`.

Images, when added, must be from openly-licensed sources only (Wikimedia Commons, CDC PHIL, PLOS, public-domain atlases). Each image must be attributed on the reference page.

## Current content

- **Cardiology** — 5 full topics (Acute coronary syndromes, Heart failure, Atrial fibrillation, Hypertension, Infective endocarditis) + 8 stubs to be written.
- **9 other specialties** (Respiratory, Nephrology, Endocrinology, GI/Hepatology, ID, Neurology, Haem-Onc, Rheumatology, Emergencies) — shown as "Coming soon" with their planned topic list so you can see the scope.

## Building

Requires JDK 17 and the Android SDK (platform-tools, platforms/android-34, build-tools/34.0.0). With `ANDROID_HOME` set:

```
./gradlew assembleDebug
./gradlew test
```

The debug APK lands at `app/build/outputs/apk/debug/app-debug.apk`.

## Disclaimer

MedBoard is a study aid and does not replace clinical judgement, local protocols or a current formulary. Verify every management recommendation against UpToDate / NICE / your local guideline before applying it to a patient.
