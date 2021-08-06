// 캡슐화

// 레코드 캡슐화 하기

// 중첩된 레코드 캡슐화 하기

// JSON 해시맵으로 고객 정보를 저장. ID를 키로 사용
const customerData = {
  1920: {
    name: "MPaul",
    id: "1920",
    usages: { 2016: { 1: 50, 2: 55 }, 2015: { 1: 70, 2: 63 } },
  },
  38673: {
    name: "NPord",
    id: "38673",
  },
};

// 쓰기 예
customerData[customerID].usages[year][month] = amount;
// 읽기 예
function compareUsage(customerID, laterYear, month) {
  const later = customerData[customerID].usages[laterYear][month];
  const earlier = customerData[customerID].usages[laterYear - 1][month];
  return { laterAmount: later, change: later - earlier };
}

// 변수 캡슐화
function getRawDataOfCustomers() {
  return customerData;
}
function setRawDataOfCustomers(arg) {
  customerData = arg;
}

// 쓰기 예
getRawDataOfCustomers()[customerID].usages[year][month] = amount;

// 읽기 예
function compareUsage(customerID, laterYear, month) {
  const later = getRawDataOfCustomers()[customerID].usages[laterYear][month];
  const earlier = getRawDataOfCustomers()[customerID].usages[laterYear][month];
  return { laterAmount: later, change: later - earlier };
}

// 레코드 캡슐화 작업
class CustomerData {
  constructor(data) {
    this._data = data;
  }

  // 쓰기
  setUsage(customerID, year, month, amount) {
    this._data[customerID].usages[year][month] = amount;
  }
  // 읽기
  usage(customerID, year, month) {
    return this._data[customerID].usages[year][month];
  }
  // 깊은 복사를 하여 수정의 빠진부분 확인
  get rawData() {
    return _.cloneDeep(this._data);
  }
}

function getCustomerData() {
  return customerData;
}
function getRawDataOfCustomers() {
  return customerData.rawData;
}
function setRawDataOfCustomers(arg) {
  customerData = new CustomerData(arg);
}

// 쓰기의 함수추출화
setUsage(customerID, year, month, amount);

function setUsage(customerID, year, month, amount) {
  getRawDataOfCustomers()[customerID].usages[year][month] = amount;
}

// 위 함수를 클래스로 함수옮기기
getCustomerData().setUsage(customerID, year, month, amount);

function compareUsage(customerID, laterYear, month) {
  const later = getCustomerData().usage(customerID, laterYear, month);
  const earlier = getCustomerData().usage(customerID, laterYear - 1, month);
  return { laterAmount: later, change: later - earlier };
}
