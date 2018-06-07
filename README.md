# tuktukfx
Generic Task handling library for JavaFX

* Separation of tasks from JavaFX with TaskStatusAdapter.
```java
void updateMessage(String message);
void updateProgress(double numerator, double denominator);
void updateTitle(String message);
boolean isCancelled();
```
* Event-based notification
```java
addObserver(TaskEventType.CURSOR, new ProgressObserver(task, timingData));
```
* Business logic contained within TaskProcessor (that you supply)
```
@Override
public void process(TaskStatusAdapter task, FileProcessorArgs args) throws CoreExceotion {
	int count = 0;
	while (!task.isCancelled()) {
		processingTask.notifyObservers(new CursorTaskEvent(++count));
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
