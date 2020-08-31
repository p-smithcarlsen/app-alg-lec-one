def main():
    N = int(input())
    v_1 = list(map(int, list(input().split())))
    v_2 = list(map(int, list(input().split())))

    inner_product = 0
    for i in range(N):
        inner_product+=(v_1[i]*v_2[i])
    
    print(inner_product)

if __name__ == "__main__":
    main()
