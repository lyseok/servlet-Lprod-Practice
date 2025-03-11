# MyBatis 기반 Servlet 프로젝트

## ✨ 개요

이 프로젝트는 **Servlet과 MyBatis**를 활용하여 웹 애플리케이션을 개발하는 연습을 위한 것입니다.

MyBatis를 사용하여 데이터베이스와 연동하고, Servlet을 이용해 클라이언트의 요청을 처리하며, JSP와 연계하여 데이터를 화면에 출력하는 기능을 포함합니다.

---

## ✨ 사용 기술

- **Java (JDK 11 이상)**: Servlet 기반 웹 개발
- **Jakarta Servlet (Servlet API 6.0)**: 요청 및 응답 처리
- **JSP (JavaServer Pages)**: 동적 웹 페이지 렌더링
- **MyBatis**: SQL Mapper 프레임워크
- **JQuery & Fetch API**: 비동기 요청 처리
- **Bootstrap 5**: UI 스타일링

---

## ✨ 프로젝트 구조

```
src/
├── prod/
│   ├── controller/            // 서블릿 컨트롤러
│   │   ├── LprodList.java      // Lprod 목록 조회 서블릿
│   │   ├── ProdById.java       // 상품 ID로 조회 서블릿
│   │   ├── ProdByLgu.java      // Lprod_gu별 상품 조회 서블릿
│   │
│   ├── dao/                   // DAO (Data Access Object)
│   │   ├── IProdDao.java       // DAO 인터페이스
│   │   ├── ProdDaoImpl.java    // DAO 구현체 (MyBatis 활용)
│   │
│   ├── service/                // 서비스 레이어
│   │   ├── IProdService.java   // 서비스 인터페이스
│   │   ├── ProdServiceImpl.java // 서비스 구현체
│   │
│   ├── vo/                     // VO (Value Object)
│   │   ├── LprodVO.java        // Lprod 객체
│   │   ├── ProdVO.java         // Prod 객체
│
├── util/
│   ├── MyBatisUtil.java         // MyBatis 설정 및 SqlSession 제공
│
webapp/
├── js/
│   ├── main.js                  // 비동기 요청 및 데이터 처리
│
├── view/
│   ├── lprodlist.jsp            // Lprod 목록 출력 JSP
│   ├── prodList.jsp             // Prod 목록 출력 JSP
│   ├── prod.jsp                 // 단일 상품 정보 출력 JSP
│
├── mybatis/
│   ├── config/
│   │   ├── mybatis-config.xml   // MyBatis 설정 파일
│   │
│   ├── mappers/
│   │   ├── prod-mapper.xml      // SQL Mapper 파일
│
├── lprod_prod.html               // 프론트엔드 UI 페이지
│
WEB-INF/
├── web.xml                      // 서블릿 매핑 및 웹 애플리케이션 설정

```

---

## ✨ 주요 기능

### 1. **Lprod 목록 조회 (`lprodList.do`)**

- `/lprodList.do` 서블릿을 통해 데이터베이스의 `lprod` 테이블 데이터를 가져옴
- MyBatis를 사용하여 DAO에서 데이터 조회 후 JSP로 전달
- `lprodlist.jsp`에서 데이터를 화면에 출력

### 2. **Lprod_gu별 상품 조회 (`prodByLgu.do`)**

- 특정 `lprod_gu` 값을 기준으로 `prod` 테이블에서 해당 상품 목록을 조회
- `prodByLgu.do` 서블릿에서 요청을 받아 MyBatis를 통해 데이터 조회 후 반환
- `prodList.jsp`에서 데이터 출력

### 3. **상품 ID로 조회 (`prodById.do`)**

- `prod_id`를 입력받아 해당 상품 정보를 조회
- `prodById.do` 서블릿을 통해 MyBatis를 사용하여 `prod` 테이블에서 데이터를 조회
- `prod.jsp`에서 상품 정보를 테이블 형식으로 출력

### 4. **프론트엔드 UI 연동 (`lprod_prod.html`)**

- `lprod_prod.html` 페이지에서 버튼 클릭 시 `fetch` API를 이용해 서버와 비동기 통신
- `main.js`에서 `lprodList.do`를 호출하여 Lprod 목록을 불러옴
- `lprod` 선택 시 `prodByLgu.do` 호출하여 해당 Lprod_gu에 속하는 상품 목록 조회
- `prod` 선택 시 `prodById.do` 호출하여 상품 상세 정보 조회

---

## ✨ 실행 방법

### 1. **Tomcat 서버 설정**

- `web.xml`에서 서블릿 매핑 확인 (`/lprodList.do`, `/prodByLgu.do`, `/prodById.do`)
- 애너테이션 기반 서블릿 등록 확인 (`@WebServlet`)
- Tomcat 실행 후 브라우저에서 URL 접근

### 2. **테스트 URL 예시**

- Lprod 목록 조회: `http://localhost:8080/servletLprodPractice/lprodList.do`
- 특정 Lprod_gu의 상품 조회: `http://localhost:8080/servletLprodPractice/prodByLgu.do`
- 상품 상세 조회: `http://localhost:8080/servletLprodPractice/prodById.do`
- HTML 프론트엔드 테스트: `http://localhost:8080/servletLprodPractice/lprod_prod.html`

### 3. **프로젝트 빌드 및 실행**

- Eclipse 또는 IntelliJ에서 실행 가능
- Maven을 이용하여 실행 가능
