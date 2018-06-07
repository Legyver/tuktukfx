# tuktukfx
Generic Task handling library for JavaFX

* Separation of tasks from JavaFX with TaskAdapter.
* Event-based notification
```java
addObserver(TaskEventType.CURSOR, new ProgressObserver(task, timingData));
```
* ProtoTaskFlow
```java
addObservers(adapter);

TaskProcessor taskProcessor = getTaskProcessor();
taskProcessor.process(adapter, getTaskProcessorArgs());

updateInstafeed(adapter, "");
updateStatus(adapter, "Done");
updateProgress(adapter, domain, domain);//complete
```
