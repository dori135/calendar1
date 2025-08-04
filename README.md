# 📅 calendar 프로젝트
## 프로젝트 설명
JPA를 활용한 upgrade 일정 관리 앱 서버를 만드는 것이 목표인 프로젝트입니다.

## 📋 API 명세서

### 🗒️ 일정(schedule)

| Method | Endpoint | 설명 | 요청 예시 | 응답 예시 | 상태 코드 |
|---|---|---|---|---|---|
|POST|/schedules | 일정 생성 | `{"title":"할 일", "contents":"내용"}` | `{"id":10, "title":"할 일", "contents":"내용", "commentCount":0}` | 201 Created |
|GET|/schedules/{id}| 일정 단건 조회 | - | `{"id":10,  "title":"할 일",  "contents":"내용", "commentCount":0}` | 200 OK |
|PUT|/schedules/{id}| 일정 수정 | `{"title":"수정된 제목", "contents":"수정된 내용"}` | `{"id":10, "title":"수정된 제목", "contents":"수정된 내용", "commentCount": 0}` | 200 OK |
|GET|/schedules| 일정 목록 조회 | - | `[{"id":10, "title":"할 일", "contents":"내용", "commentCount":0}, {"id":11, "title":"할 일", "contents":"내용", "commentCount":0}]` | 200 OK |
|DELETE|/schedules/{id}| 일정 삭제 | - | - | 204 No Content |

### 💬 댓글(comment)

| Method | Endpoint | 설명 | 요청 예시 | 응답 예시 | 상태 코드 |
|---|---|---|---|---|---|
|POST|/schedules/{scheduleId}/comments | 댓글 생성 | `{"content":"댓글", "name":"김영희"}` | `{"id":5, "content":"댓글", "name":"김영희", "scheduleId":10}` | 201 Created |
|GET |/schedules/{scheduleId}/comments/{commentId}| 댓글 단건 조회 | - |  `{"id":5, "content":"댓글", "name":"김영희", "scheduleId":10}` | 200 OK |
|GET|/schedules/{scheduleId}/comments| 댓글 전체 조회 | - |  `[{"id":5, "content":"댓글", "name":"김영희", "scheduleId":10}]` | 200 OK |
|PUT|/schedules/{scheduleId}/comments/{commentId}| 댓글 수정 | `{"content":"수정된 댓글"}` | `{"id":5, "content":"수정된 댓글", "name":"김영희", "scheduleId":10}` | 200 OK |
|DELETE|	/schedules/{scheduleId}/comments/{commentId} | 댓글 삭제 | - | - | 204 No Content |

### 👥 유저(User)

| Method | Endpoint| 설명| 요청 예시 | 응답 예시 | 상태 코드 |
|---|---|---|---|---|---|
|POST |/users| 유저 생성 | `{"name":"김영희","email":"abc@example.com"}` | `{"id":1,"name":"김영희","email":"abc@example.com"}` | 201 Created |
|GET |/users/{id} | 유저 단건 조회 |- |  `{"id":1,"name":"김영희","email":"abc@example.com"}` | 200 OK |
|GET|/users | 유저 전체 조회 | - |  `[{"id":1,"name":"김영희","email":"abc@example.com"}]` | 200 OK |
|DELETE|/users/{id} | 유저 삭제| - | - | 204 No Content |

### ⚠️ 예외 처리
- 400 Bad Request: 필수 필드 누락, 토큰 없음, 잘못된 요청 등
- 401 Unauthorized: 로그인 실패(이메일과 비밀번호 불일치), 토큰 만료 등
- 403 Forbidden: 권한이 없는 사용자 접근
- 404 Not Found: 존재하지 않는 페이지나 파일을 요청


## ERD

<img width="908" height="458" alt="image" src="https://github.com/user-attachments/assets/7a3aed46-bdcc-4041-bcde-218aaf5b2f47" />