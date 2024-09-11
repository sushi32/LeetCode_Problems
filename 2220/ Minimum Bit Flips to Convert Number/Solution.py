class Solution:
    def minBitFlips(self, start: int, goal: int) -> int:
        xorVal = start ^ goal
        bitFlips = 0

        while xorVal:
            bitFlips += 1 if (xorVal & 1) else 0
            xorVal >>= 1

        return bitFlips


if __name__ == "__main__":
    s = Solution()
    print(s.minBitFlips(7, 10))
