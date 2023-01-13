import request from '@/utils/request'

// 查询信用卡列表
export function listCard(query) {
  return request({
    url: '/business/card/list',
    method: 'get',
    params: query
  })
}

// 查询信用卡详细
export function getCard(id) {
  return request({
    url: '/business/card/' + id,
    method: 'get'
  })
}

// 新增信用卡
export function addCard(data) {
  return request({
    url: '/business/card',
    method: 'post',
    data: data
  })
}

// 修改信用卡
export function updateCard(data) {
  return request({
    url: '/business/card',
    method: 'put',
    data: data
  })
}

// 删除信用卡
export function delCard(id) {
  return request({
    url: '/business/card/' + id,
    method: 'delete'
  })
}
