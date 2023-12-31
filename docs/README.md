## 기능구현

1. 방문일자를 입력합니다.
    - 1 <= 날짜 <= 31
    - 🔊 예외처리: "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
    - 출력: "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
      12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"

2. 주문 메뉴를 입력합니다.
    - 쉼표(,)를 기준으로 메뉴를 구분합니다.
    - 입력양식: [메뉴명]-[메뉴개수] ex. 시저샐러드-1,해산물파스타-2...
      - 🔊 예외처리:
        1) 메뉴판에 없는 경우: "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
        2) 메뉴개수가 1미만인 경우: "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
        3) 메뉴 형식이 올바르지 않은 경우: "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
        4) 중복으로 메뉴 이름을 작성한 경우: "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
        5) 메뉴 개수가 20개가 초과된 경우: "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
    - 출력: "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"

3. 할인 내역을 안내합니다.
    - 총 주문 금액이 10,000원 이상이어야 합니다.
    - 음료만 주문 할 수 없습니다.
   
    🎁 크리스마스 디데이 할인
      1) 📆 기간: 2023.12.1 ~ 2023.12.25
      2) 1,000원 시작 > 날마다 100원씩 증가 (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
      3) 충 주문 금액에서 할인됩니다.



    🎁 12월 이벤트 할인
      1) 📆 기간: 2023.12.1 ~ 2023.12.31
      2) 평일할인(일~목): 디저트 메뉴 2,023원 할인 (개당)
      3) 주말할인(금~토): 메인메뉴 2,023원 할인 (개당) 
      4) 특별할인: 이벤트 달력에 별이 있는 경우 총 주문에서 - 1,000원 할인
      5) 증정 이벤트: 할인 전 금액이 12만원 이상인 경우 - 샴페인 증정
   
    - 출력: 12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
      <주문메뉴>
      타파스 1개
      제로콜라 1개
      ## 주문 메뉴 출력순서는 자유롭게 출력한다.
      <할인 전 총주문 금액>
      8,500원
      ## 모든 메뉴의 금액을 더해 출력한다.
      <증정 메뉴>
      없음
      ## 증정 이벤트에 해당하지 않으면 "없음"을 출력한다.
      <혜택 내역>
      없음
      ## 고객에게 적용된 이벤트 내역만 출력
      ## 이벤트 적용 없음: "없음"을 출력한다.
      ## 여러 이벤트 적용: 출력 순서는 자유롭게 출력한다.
      <총혜택금액>
      0원
      ## 할인 금액의 합계 + 증정 메뉴의 가격
      <할인 후 예상 결제 금액>
      ## 할인 전 총주문 금액 - 할인 금액
      8,500원
      <12월 이벤트 배지>
      없음
      