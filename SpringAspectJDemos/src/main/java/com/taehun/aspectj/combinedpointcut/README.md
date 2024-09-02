# Spring AOP와 AspectJ를 활용한 결합된 포인트컷 예제

이 프로젝트는 Spring AOP와 AspectJ를 사용하여 결합된 포인트컷(Combined Pointcuts)을 구현한 예제입니다. 이 예제에서는 웹 레이어, 서비스 레이어, 데이터 액세스 레이어에서 발생하는 메서드 호출에 대해 로깅하는 기능을 구현합니다.

## 프로젝트 구성

### 1. 주요 패키지

- `com.taehun.aspectj.combinedpointcut.aspect`: AOP 어드바이스와 포인트컷을 정의한 클래스들이 포함됩니다.
- `com.taehun.aspectj.combinedpointcut.config`: Spring 설정 클래스가 포함됩니다.
- `com.taehun.aspectj.combinedpointcut.dao`: 데이터 액세스 레이어를 담당하는 클래스가 포함됩니다.
- `com.taehun.aspectj.combinedpointcut.pointcuts`: 포인트컷을 정의하는 클래스가 포함됩니다.
- `com.taehun.aspectj.combinedpointcut.service`: 서비스 레이어를 담당하는 클래스가 포함됩니다.
- `com.taehun.aspectj.combinedpointcut.web`: 웹 레이어를 담당하는 클래스가 포함됩니다.

### 2. 주요 기능

- **포인트컷 정의 및 결합**: 다양한 레이어(웹, 서비스, 데이터 액세스)에서 포인트컷을 정의하고 이를 결합하여 로깅 기능을 구현합니다.
- **로깅 기능**: 각 레이어에서 발생하는 메서드 호출을 감지하여 로그를 출력합니다.

### 3. 실행 방법

1. `Main` 클래스를 실행하여 웹 레이어, 서비스 레이어, 데이터 액세스 레이어의 메서드를 호출합니다.
2. 콘솔에서 각 레이어에 대해 정의된 어드바이스가 실행되며, 메서드 이름과 클래스 이름이 로그로 출력됩니다.

### 4. 학습 목표

- Spring AOP에서 포인트컷을 정의하고 결합하는 방법을 학습합니다.
- 다양한 레이어에 대해 AOP 어드바이스를 적용하여 공통 기능(예: 로깅)을 구현합니다.

이 프로젝트는 AOP의 핵심 개념을 이해하고, Spring과 AspectJ를 통해 실습하는 데 중점을 두고 있습니다.
