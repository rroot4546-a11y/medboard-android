# MedBoard

A modern, offline-first Android study companion for internal-medicine board revision. Built with Kotlin, Jetpack Compose and Material 3 (minSdk 26, targetSdk 34).

> **Study aid only:** MedBoard is not a clinical decision-support system. Verify management and prescribing against current local guidance and a live formulary.

## Current experience

- **Structured medical reader** for sections, paragraphs, ordered and bullet lists, horizontally scrollable tables, safety/exam callouts, board pearls and tap-to-reveal rapid Q&A.
- **Full-content ranked search** across topic titles and subtitles, specialty names/descriptions, section/subheadings, paragraphs, list items, table titles/headers/cells, callouts, pearls, and Q&A questions/answers. Results explain where a match occurred and show a context snippet.
- **Persistent study state** backed by Preferences DataStore: bookmarks and an eight-topic recently opened history survive process/device restarts.
- **Study dashboard** with content metrics, recent/bookmarked continuation cards, and an adaptive specialty grid for phones and larger widths.
- **Material 3 light/dark/system themes**, edge-to-edge layout, readable typography and explicit empty/planned states.
- **Automated corpus validation** for duplicate IDs, required ready-topic blocks/references, malformed tables, blank content, suspicious truncated endings, raw/unbalanced Markdown, extreme whitespace, and prompt/placeholder leakage.

The bundled corpus currently covers reviewed topics across cardiology, respiratory medicine, nephrology, endocrinology, gastroenterology/hepatology, infectious diseases and neurology. Planned topic stubs are deliberately visible but clearly disabled until reviewed content exists.

## Content policy

Every topic must be an **original concise summary written in the contributors' own words**. Harrison's Principles of Internal Medicine (21st ed.) and Davidson's Principles and Practice of Medicine (24th ed.) are cited as study references; their prose, tables and figures must not be copied into this repository.

When contributing content:

1. Write a fresh synthesis rather than paraphrasing line by line.
2. Add meaningful `TopicReference` entries and source attribution.
3. Include sections, board pearls and rapid Q&A for every ready topic.
4. Use openly licensed images only, with an explicit source and licence.
5. Run the validator-backed unit tests before opening a PR.

## Build and test

Requirements:

- JDK 17
- Android SDK platform 34 and Build Tools 34.0.0

With `ANDROID_HOME`/`ANDROID_SDK_ROOT` configured:

```bash
./gradlew :app:testDebugUnitTest --no-daemon
./gradlew :app:assembleDebug --no-daemon
```

The APK is written to `app/build/outputs/apk/debug/app-debug.apk`. Unit-test HTML reports are under `app/build/reports/tests/testDebugUnitTest/`.

## Architecture

The app intentionally keeps a small dependency footprint:

- immutable Kotlin content models and per-specialty registries
- deterministic in-memory search index over the bundled corpus
- Compose navigation and stateless screens fed through composition locals
- Preferences DataStore for lightweight user study state
- JVM tests for registry/search and content-integrity invariants

## Disclaimer

MedBoard does not replace clinical judgement, local protocols, specialist advice, or an up-to-date formulary. Medical recommendations evolve; check current authoritative guidance before applying any information to patient care.
