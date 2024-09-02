# AspectJ와 Spring AOP를 이용한 예제 프로젝트

이 프로젝트는 AspectJ와 Spring AOP를 활용하여 다양한 AOP(Aspect-Oriented Programming) 기능을 연습하기 위해 작성되었습니다. 주로 사용하는 기능들은 다음과 같습니다:

- **@Around, @Before, @AfterReturning, @AfterThrowing** 등 AOP 어드바이스의 다양한 활용
- **@Pointcut**을 이용한 메서드 매칭
- **@DeclareParents**를 사용한 인터페이스 구현 도입 (Introduction)
- **@Aspect**를 활용한 다양한 시점에서의 로깅, 유효성 검사, 성능 측정
- **AtomicInteger**를 사용한 스레드 안전성 보장 및 카운팅 기능

## 프로젝트 구성

### 1. 주요 패키지

- `com.taehun.aspectj.declaringadvice.annotation`: 사용자 정의 어노테이션과 Enum을 포함합니다.
- `com.taehun.aspectj.declaringadvice.aop`: 다양한 AOP 기능을 구현한 Aspect 클래스들이 포함됩니다.
- `com.taehun.aspectj.declaringadvice.config`: Spring 설정을 위한 설정 클래스가 포함됩니다.
- `com.taehun.aspectj.declaringadvice.dao`: 데이터 액세스 레이어로, 계좌 정보를 관리하는 DAO 클래스가 포함됩니다.
- `com.taehun.aspectj.declaringadvice.model`: 모델 클래스들이 포함됩니다.
- `com.taehun.aspectj.declaringadvice.service`: 서비스 레이어로, 계좌 서비스 및 기타 비즈니스 로직을 담당하는 클래스가 포함됩니다.

### 2. 주요 기능

- **AspectJ를 활용한 메서드 실행 시간 측정**: `TimingAspect` 클래스에서 메서드 실행 시간을 측정합니다.
- **계좌 유효성 검사**: `AccountValidationAspect`에서 계좌의 유효성을 검사합니다.
- **사용자 행동 로깅**: `AuditAspect`에서 사용자 행동을 로깅합니다.
- **메서드 실행 횟수 카운팅**: `ExecutionCountingAspect`에서 특정 메서드의 실행 횟수를 카운팅합니다.
- **서비스 메서드에 대한 사전 로깅**: `LoggingAspect`에서 메서드 실행 전, 후, 예외 발생 시 로깅합니다.

### 3. 실행 방법

프로젝트의 `Main` 클래스를 실행하여 각 서비스 메서드와 어드바이스의 동작을 확인할 수 있습니다. 주석 처리된 메서드를 하나씩 활성화하여 실행 결과를 비교해 볼 수 있습니다.

### 4. 주의 사항

- **빈 설정 오류**: 만약 Spring 컨텍스트 초기화 중 빈을 찾지 못하는 경우, `@ComponentScan` 설정을 다시 확인해야 합니다. 모든 관련 패키지가 스캔되도록 설정되어야 합니다.
- **스레드 안전성**: `ExecutionCountingAspect` 클래스에서는 `AtomicInteger`를 사용하여 멀티스레드 환경에서 안전하게 메서드 실행 횟수를 카운팅합니다.

이 프로젝트는 AOP의 핵심 개념을 연습하고 Spring과 AspectJ의 통합을 실습하는 데에 중점을 두고 있습니다.
