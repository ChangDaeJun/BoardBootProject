# TDD and SOLID principles
SpringBoot, JPA를 사용한 게시판 프로젝트입니다.

### 목적
```
1. TDD 개발
2. 객체지향 원칙(SOLID) 준수
3. 기존 프로젝트의 개선
```

### 기존 프로젝트([Board Project](https://github.com/ChangDaeJun/Board-Project))의 문제
1. SOLID 원칙의 위배, 특히 의존관계 역전 원칙에 위배되었다.
2. 서비스 객체가 과도하게 많아졌다. 확장을 위한 선택이었으나, 오히려 서비스 제작 시 필요한 객체 수가 많이 증가하였다.
3. 테스트 코드를 작성하지 않았다.
4. Repository의 기능과 Service의 기능을 혼동하여 사용했다.
5. 데이터베이스 코드 중복을 줄였지만, 여전히 불편하다.

### 해결책
1. 의존관계 역전 원칙 준수를 위하여 Spring을 사용하였다. 특히, 더 빠른 개발을 위해 환경설정이 포함된 Boot를 사용하였다.
2. 너무 많은 서비스가 생기지 않도록, 서비스의 종류를 Create, Read, Update, Delete의 4가지 기능으로만 나누었다.
3. 테스트 코드를 반드시 작성할 수 있도록, TDD 방식을 채택하였다.
4. 상당 수의 기능(대부분은 find, get)을 Repository로 옮기고, Service에는 핵심 기능만을 담았다.
5. JPA를 통해 빠른 데이터베이스 구현을 신속하게 하였다.
6. 요구 분석 -> 인터페이스 제작 -> 테스트 코드 작성 -> 구현 -> 테스트 통과의 순으로 프로젝트 개발을 진행하였다.

## 프로젝트 소개

### 요구 분석
* 글(Board) : 글 쓰기, 글 지우기, 글 업데이트, 글 상세 조회, 글 목록 조회
* 댓글(Comment) : 댓글 쓰기, 댓글 지우기, 댓글 업데이트, 글에 작성된 댓글 조회, 회원 별 작성 댓글 보기
* 좋아요(Like) : 좋아요 등록, 좋아요 취소, 회원 별 좋아요 눌른 글 보기
* 유저(User) : 유저 회원가입, 유저 정보 변경, 유저 회원탈퇴, 유저 페이지 

### 인터페이스 설계 
* 유저(User)
<img width="466" alt="image" src="https://user-images.githubusercontent.com/97227920/227390911-f5a2e328-9dac-4d25-b0c3-4026096f32d7.png">
<img width="591" alt="image" src="https://user-images.githubusercontent.com/97227920/227391272-4ed05656-c338-4309-b909-ef9325b06052.png">

* 글(Board)
<img width="499" alt="image" src="https://user-images.githubusercontent.com/97227920/227391478-f4c83e64-d99b-477a-868d-3ec3612a5e7f.png">

* 댓글(Comment)
<img width="581" alt="image" src="https://user-images.githubusercontent.com/97227920/227391671-711565de-bb21-4745-a4cf-530be59a33d2.png">

* 좋아요(Like)
<img width="579" alt="image" src="https://user-images.githubusercontent.com/97227920/227391847-1d0e1e4a-dc8b-4e05-a11a-08122416e266.png">

### 테스트 코드 작성

### 구현

### 프로젝트 구조
![최종](https://user-images.githubusercontent.com/97227920/227275691-76473f37-ed4f-410e-9ed9-2cc6906573fb.png)
