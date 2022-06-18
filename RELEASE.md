# Releases
## 2.0.0
- Adapted Semantic Versioning 2.0
- Compiled on JDK 11
## 1.2.0
Made publish com.legyver.tuktukfx module
## 1.1.0
Breaking release.  Simplified API.
- JavaFxAdapter removed from library to remove dependency on JavaFX
- TaskContext removed from library to simplify usage.  Extend TaskTimingData directly instead.
- TaskProcessorArgs removed from library to simplify usage.  Pass any necessary args to your TaskProcessor using the constructor.
- Removed unused parameterized type from ProtoTaskFlow
 
### New Stuff
- Task Abortion
    - type: IAbortTask
    - convenience baseClass: AbstractAbortableTask
    - adapter: AbortableTaskStatusAdapter

### Refactoring
- TaskProcessor now takes parameterized type of TaskStatusAdapter
- AbstractObservableTask now takes parameterized type of TaskStatusAdapter

## 1.0
Original release.