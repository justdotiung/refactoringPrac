// 매개변수 객체 만들기

// 예시
// 온도 측정값 배열에서 정상작동 범위를 벗어난 것이 있는지 검사하는 코드
const station = {
  name: "ZB1",
  readings: [
    { temp: 47, time: "2016-11-10 09:10" },
    { temp: 53, time: "2016-11-10 09:20" },
    { temp: 58, time: "2016-11-10 09:30" },
    { temp: 53, time: "2016-11-10 09:40" },
    { temp: 51, time: "2016-11-10 09:50" },
  ],
};

// 정상범위를 벗아난 측정값을 찾는 함수
function readingsOutsideRange(station, min, max) {
  return station.readings.filter((r) => r.temp < min || r.temp > max);
}

//호출문
alerts = readingsOutsideRange(
  station,
  operatingPlan.temperatureFloor,
  operatingPlan.temperatureCeiling
);

// 묶은 데이터를 표시하는 클래스
// 객체로 변경시 다양한 확장 작업을 할수있다.
class NumberRange {
  constructor(min, max) {
    this._data = { min, max };
  }

  get min() {
    return this._data.min;
  }
  get max() {
    return this._data.max;
  }

  contains(arg) {
    return arg >= this.min && arg <= this.max;
  }
}

// 새로만든 객체를 범위측정값 함수의 매개변수로 추가
function readingsOutsideRange(station, min, max, range) {
  return station.readings.filter((r) => r.temp < min || r.temp > max);
}

// 호출문
alerts = readingsOutsideRange(
  station,
  operatingPlan.temperatureFloor,
  operatingPlan.temperatureCeiling,
  null
);

// 테스트 통과후 호출문 변경
const range = new NumberRange(
  operatingPlan.temperatureFloor,
  operatingPlan.temperatureCeiling
);

//호출문
alerts = readingsOutsideRange(
  station,
  operatingPlan.temperatureFloor,
  operatingPlan.temperatureCeiling,
  range
);

//테스트 통과후 최대 최소 변경
function readingsOutsideRange(station, range) {
  return station.reading.filter(
    (r) => r.temp < range.min || r.temp > range.max
  );
}

// 클래스를 이용한 확장가능
function readingsOutsideRange(station, range) {
  return station.reading.filter((r) => !range.contains(r.temp));
}
