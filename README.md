# tuktukfx
Generic Task handling library for JavaFX
```gradle
implementation group: 'com.legyver', name: 'tuktukfx', version: '2.0.0-alpha.1'
```

## Features
* Separation of tasks from JavaFX with TaskStatusAdapter.
```java
void updateMessage(String message);
void updateProgress(double numerator, double denominator);
void updateTitle(String message);
```

(You can find a JavaFxAdapter in 'legyver:fenxlib-ext-tuktukfx')

* Event-based notification
```java
addObserver(TaskEventType.CURSOR, new ProgressObserver(task, timingData));
```
* Business logic contained within TaskProcessor (that you supply)
```
@Override
public void process(TaskStatusAdapter task) throws CoreExceotion {
	int count = 0;
	while (!task.isCancelled()) {
		processingTask.notifyObservers(new CursorTaskEvent(++count));
```
* ProtoTaskFlow
```java
addObservers(adapter);

taskProcessor.process(adapter);

updateInstafeed(adapter, "");
updateStatus(adapter, "Done");
updateProgress(adapter, domain, domain);//complete
```

## Versioning
Release.Breaking.Feature.Fix
- Release: Used for major milestone releases.
- Breaking: Used when the change breaks backward compatibility.
- Feature: Used when introducing features that do not break backward compatability.
- Fix: Used for small bug fixes
## Releases
* [Release Notes](https://github.com/Legyver/tuktukfx/blob/master/RELEASE.md)
## Licensing
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/Legyver/tuktukfx/blob/master/LICENSE)
