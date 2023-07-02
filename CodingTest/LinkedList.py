# LinkedList
# Node라는 구조체가 연결되는 형식으로 데이터를 저장하는 자료구조
# Node는 데이터 값(value)과 다음 주소값(next)로 구성되어 있다.
# 비연속적으로 저장되므로 메모리 사용이 자유롭다.
# 각각의 Node가 다음 Node의 메모리 주소값을 가리킴
# 논리적으로는 연속성을 가짐

# Node 코드
# class Node1 : 
#     def __init__(self, value = 0, next = None):
#         self.value = value
#         self.next = next

# first = Node1(1)
# second = Node1(2)
# third = Node1(3)
# first.next = second
# second.next = third
# first.value = 6

# LinkedList 코드
class Node(object):
    def __init__(self, value):
        self.value = value
        self.next = None
        self.prev = None

class LinkedList(object):
    def __init__(self):
        self.head = None
        self.tail = None

    def append(self, value):
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
            # 맨 뒤의 node 가 new_code를 가리켜야 한다.
        else:
            current = self.head
            while(current.next):
                current = current.next
            current.next = new_node

ll = LinkedList()
ll.append(1)
ll.append(2)
ll.append(3)
ll.append(4)
