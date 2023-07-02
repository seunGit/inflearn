# array 특성
# 배열은 선언시 size를 정하여 해당 size만큼의 연.속.된 메모리를 할당 받아
# data를 연속/순차적으로 저장하는 자료구조.

# 리스트의 선언
a = list()
a = [1, 2, 3]
print(a) # [1, 2, 3]

# 리스트 접근 - 0번째 원소
a[0]
print(a[0]) # 1

# 0번째 원소 업데이트
a[0] = 4
print(a) # [4, 2, 3]

# 리스트 마지막에 원소 "1" 추가
a.append(1)
print(a) # [4, 2, 3, 1]

# 중간에 원소 추가 - 2번째 index에 10 추가하기
a.insert(2, 10)
print(a) # [4, 2, 10, 3, 1]

# 마지막 원소 삭제
a.pop()
print(a) # [4, 2, 10, 3]

# 중간 원소 삭제 - 2번째 index 값 삭제
a.pop(2)
print(a)

# 중간 원소 삭제 - 4라는 값이 있으면 삭제, 없으면 error
a.remove(4)
print(a)