# 지하철 노선도 경로 조회 미션

## 🚀 기능 요구사항

### 초기 설정 

- [x] 프로그램 시작 시 아래와 같이 역, 노선, 구간 정보가 초기 설정되어야 한다.
  - 거리와 소요 시간이 양의 정수이며 단위는 km와 분을 의미한다.
```
 1. 지하철역으로 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역이 등록되어 있다.
 2. 지하철 노선으로 2호선, 3호선, 신분당선이 등록되어 있다.
 3. 노선에 역이 아래와 같이 등록되어 있다.(왼쪽 끝이 상행 종점)
   - 2호선: 교대역 - ( 2km / 3분 ) - 강남역 - ( 2km / 3분 ) - 역삼역
   - 3호선: 교대역 - ( 3km / 2분 ) - 남부터미널역 - ( 6km / 5분 ) - 양재역 - ( 1km / 1분 ) - 매봉역
   - 신분당선: 강남역 - ( 2km / 8분 ) - 양재역 - ( 10km / 3분 ) - 양재시민의숲역
 ```

### 사용자 입력

- [ ] 메인 화면에서 경로 조회 화면으로 넘어갈 수 있다.
- [x] 메인 화면에서 프로그램을 종료할 수 있다.
- [ ] 경로 조회 화면에서 `최단 거리`를 기준으로 경로를 조회할 수 있다.
- [ ] 경로 조회 화면에서 `최단 시간`을 기준으로 경로를 조회할 수 있다.
- [ ] 경로 조회시, 출발역과 도착역을 입력받아 경로를 조회한다.
- [ ] 경로 조회 화면에서 메인 화면으로 돌아갈 수 있다.

### 로직 및 출력
- [ ] 경로 조회 시 총 거리, 총 소요 시간도 함께 출력한다.
- 기대하는 출력 결과는 `[INFO]`를 붙여서 출력한다. 출력값의 형식은 예시와 동일하게 한다.

### 예외 처리

- 에러 발생 시 `[ERROR]`를 붙여서 출력한다. 에러의 문구는 자유롭게 작성한다.
- [ ] 경로 조회 시 출발역과 도착역이 같으면 에러를 출력한다.
- [ ] 경로 조회 시 출발역과 도착역이 연결되어 있지 않으면 에러를 출력한다.

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-subway-path-precourse/blob/master/LICENSE.md) licensed.
