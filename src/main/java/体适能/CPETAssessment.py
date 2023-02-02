
import pandas as pd
import numpy as np
import math
from scipy import stats

def CPETAssessment(Data):
    import pandas as pd
    import numpy as np
    import math
    from scipy import stats
    #数据转化为列表
    Parameters = Data.values.tolist()
    #将列表转化为数组
    Parameters = np.array(Parameters)
    # 数据格式转换成浮点型
    # Power=Parameters[:,1].astype('float32')，取表格中第2列数据：t
    #提取出来的每一列是按行分布的
    Power = Parameters[:, 2].astype('float32')
    HR = Parameters[:, 3].astype('float32')
    SV = Parameters[:, 4].astype('float32')
    CO = Parameters[:, 5].astype('float32')
    VO2 = Parameters[:, 6].astype('float32')
    VCO2 = Parameters[:, 7].astype('float32')
    VE = Parameters[:, 8].astype('float32')
    BOA = Parameters[:, 9].astype('float32')

    # 计算通气当量
    EQO2 = VE * 1000. / VO2
    EQO2 = np.array(EQO2)  # print(EQO2.shape)
    EQCO2 = VE * 1000. / VCO2
    EQCO2 = np.array(EQCO2)
    # 计算氧脉搏
    OP = VO2 / HR
    # 计算呼吸熵
    RQ = VCO2 / VO2
    # 计算动静脉氧分差
    Ca_vO2 = VO2 / (HR * SV)

    # 新数组
    # 按垂直方向（行顺序）堆叠数组
    parameters = np.vstack((Parameters[:, 1], Power, HR, SV, CO, VO2, VCO2, VE, EQO2, EQCO2 , OP, RQ, Ca_vO2,  BOA))
    #转置
    parameters = np.transpose(parameters)
    #数组保存；储存内容；逗号分隔数据，数据对齐
    np.savetxt("parameters.csv", parameters, delimiter=',', fmt='%s')

    ##拐点检测 AT和力竭时间点
    # AT:无氧阈
    #计算Parameters行数
    rows = len(Parameters)

    for i in range(0, rows - 1):
        #如果第i行和第i+1行的摄氧量小于二氧化碳产生量，则输出第i行的时间
        if (VO2[i] < VCO2[i] and VO2[i + 1] < VCO2[i + 1]):
            time_AT = Parameters[i, 1]
            print('AT的时间为%s' % time_AT)
            AT = i
            break

    # 力竭时间点
    for i in range(0, rows - 1):
        #如果第i+1行的功率小于第i行，则输出第i行时间
        if (Power[i + 1] < Power[i]):
            time_MAX = Parameters[i, 1]
            print('力竭的时间为%s' % time_MAX)
            MAX = i
            break
    # 确定生理特征参数
    # 心血管功能：   x1无氧阈心率            x2力竭心率
    #             x3无氧阈每搏输出量        x4力竭每搏输出量
    #             x5无氧阈氧脉搏           x6 力竭氧脉搏
    # 气体交换功能:  x7 无氧阈氧气当量        x8 力竭氧气当量
    #             x9 无氧阈通气量          x10 力竭通气量
    # 代谢能力 ：   x11 无氧阈摄氧量         x12 力竭无氧阈
    #             x13 无氧阈呼吸熵         x14 力竭呼吸熵
    #             x15无氧阈动静脉氧分差     x16力竭动静脉氧分差
    #AT=i
    x1 = HR[AT]
    HR_AT=HR[AT]
    x1_max = 173
    x1_min = 71
    # x1=(HR[AT]-x1_min)/(x1_max-x1_min)
    x2 = HR[MAX]
    x2_max = 198
    x2_min = 115
    # x2=(HR[MAX]-x2_min)/(x2_max-x2_min)
    x3 = SV[AT]
    x3_max = 132
    x3_min = 8.8
    # x3=(SV[AT]-x3_min)/(x3_max-x3_min)
    x4 = SV[MAX]
    x4_max = 192.1
    x4_min = 12.1
    # x4=(SV[MAX]-x4_min)/(x4_max-x4_min)
    x6 = OP[MAX]
    x6_max = 22.6
    x6_min = 6.8
    # x6=(OP[MAX]-x6_min)/(x6_max-x6_min)
    # 气体交换功能
    x7 = EQO2[AT]
    x7_max = 33.1
    x7_min = 20.2
    # x7=(x7_max-EQO2[AT])/(x7_max-x7_min)
    x8 = EQO2[MAX]
    x8_max = 72.3
    x8_min = 22.5
    # x8=(x8_max-EQO2[MAX])/(x8_max-x8_min)
    x9 = VE[AT]
    x9_max = 82.8
    x9_min = 18.3
    # x9=(VE[AT]-x9_min)/(x9_max-x9_min)
    x10 = VE[MAX]
    x10_max = 168.6
    x10_min = 28.4
    # x10=(VE[MAX]-x10_min)/(x10_max-x10_min)
    # 代谢功能
    x11 = VO2[AT]
    x11_max = 39.4
    x11_min = 14.06
    # x11=(VO2[AT]-x11_min)/(x11_max-x11_min)
    x12 = VO2[MAX]
    x12_max = 61.02
    x12_min = 21.68
    # x12=(VO2[MAX]-x12_min)/(x12_max-x12_min)
    x14 = RQ[MAX]
    x14_max = 1.47
    x14_min = 0.97
    # x14=(RQ[MAX]-x14_min)/(x14_max-x14_min)
    x15 = Ca_vO2[AT]
    x15_max = 0.977
    x15_min = 0.105
    # x15=(Ca_vO2[AT]-x15_min)/(x15_max-x15_min)
    x16 = Ca_vO2[MAX]
    x16_max = 0.880
    x16_min = 0.0916
    # x16=(Ca_vO2[MAX]-x16_min)/(x16_max-x16_min)

    # 综合能力评分 MroScore
    # 定义正负理想解
    # 定义初始评价矩阵
    #构建一个3×14的数组
    matrix = np.zeros((3, 14))
    #第一行，原始值
    matrix[0, :] = [x1, x2, x3, x4, x6, x7, x8, x9, x10, x11, x12, x14, x15, x16]
    #矩阵第二行，定义最大值
    matrix[1, :] = [x1_max, x2_max, x3_max, x4_max, x6_max, x7_max, x8_max, x9_max, x10_max, x11_max, x12_max, x14_max,
                    x15_max, x16_max]
    #矩阵第三行，定义最小值
    matrix[2, :] = [x1_min, x2_min, x3_min, x4_min, x6_min, x7_min, x8_min, x9_min, x10_min, x11_min, x12_min, x14_min,
                    x15_min, x16_min]
    # 整理想解
    #创建2×14的矩阵
    D = np.zeros((2, 14))
    #创建变量s1和s2
    s1 = 0
    s2 = 0
    #14个指标的权重
    Weight = [0.078, 0.058, 0.073, 0.048, 0.075, 0.096, 0.064, 0.075, 0.087, 0.064, 0.111, 0.053, 0.054, 0.066]

    # 心血管能力 Score1
    #从X1~X6,除开X5，共5个参数
    #生成一个2×5的数组
    D = np.zeros((2, 5))
    s1 = 0
    s2 = 0
    for i in range(0, 5):
        D[0, i] = Weight[i] * ((matrix[0, i] - matrix[1, i]) / (matrix[1, i] - matrix[2, i]))
        s1 = s1 + pow(D[0, i], 2)
    s1 = math.sqrt(s1)
    for i in range(0, 5):
        D[1, i] = Weight[i] * ((matrix[0, i] - matrix[2, i]) / (matrix[1, i] - matrix[2, i]))
        s2 = s2 + pow(D[1, i], 2)
    s2 = math.sqrt(s2)
    Score1 = 70.855 * s2 / (s1 + s2) + 40.615
    Score1 = round(Score1, 1)
    print('心血管能力得分为%10.1f' % Score1)

    # 呼吸能力  Score2
    #从x7-x10
    D = np.zeros((2, 4))
    s1 = 0
    s2 = 0
    for i in range(0, 4):
        D[0, i] = Weight[i] * ((matrix[0, i + 5] - matrix[1, i + 5]) / (matrix[1, i + 5] - matrix[2, i + 5]))
        s1 = s1 + pow(D[0, i], 2)
    s1 = math.sqrt(s1)
    for i in range(0, 4):
        D[1, i] = Weight[i] * ((matrix[0, i + 5] - matrix[2, i + 5]) / (matrix[1, i + 5] - matrix[2, i + 5]))
        s2 = s2 + pow(D[1, i], 2)
    s2 = math.sqrt(s2)
    Score2 = 69.855 * s2 / (s1 + s2) + 48.615
    Score2 = round(Score2, 1)
    print('呼吸能力得分为%10.1f' % Score2)

    # 代谢能力  Score3
    D = np.zeros((2, 5))
    s1 = 0
    s2 = 0
    for i in range(0, 5):
        D[0, i] = Weight[i] * ((matrix[0, i + 9] - matrix[1, i + 9]) / (matrix[1, i + 9] - matrix[2, i + 9]))
        #循环后的累加平方和s1=0+pow(D[0, 0], 2)+pow(D[0, 1], 2)+pow(D[0, 2], 2)+pow(D[0, 3], 2)+pow(D[0, 4], 2)
        s1 = s1 + pow(D[0, i], 2)
    s1 = math.sqrt(s1)
    for i in range(0, 5):
        D[1, i] = Weight[i] * ((matrix[0, i + 9] - matrix[2, i + 9]) / (matrix[1, i + 9] - matrix[2, i + 9]))
        s2 = s2 + pow(D[1, i], 2)
    s2 = math.sqrt(s2)
    Score3 = 70.855 * s2 / (s1 + s2) + 44.615
    Score3 = round(Score3, 1)
    print('代谢能力得分为%10.1f' % Score3)
    #心肺耐力综合得分
    MroScore = (Score1 + Score2 + Score3) / 3
    # 保留1位小数字
    MroScore = round(MroScore, 1)
    print('心肺耐力综合得分为%10.1f' % MroScore)

    #乳酸耐受力 Score4
    Score4 = (((10 / 9) * HR[MAX] - 80) + ((1 / 105) * VO2[MAX] + 27)) / 2
    Score4 = round(Score4, 1)
    print('乳酸耐受力为%10.1f' % Score4)

    # 期待分数
    EXP_MroScore = 1.095 * MroScore
    EXP_MroScore = round(EXP_MroScore, 1)
    print('期待的心肺耐力综合得分为%10.1f' % EXP_MroScore)
    result=[time_AT,time_MAX,MroScore,Score1,Score2,Score3,Score4,EXP_MroScore,HR_AT]
    return result

Data= pd.read_csv(r'D:\python\Lib\site-packages\pandas\io\parsers\data\9.csv')
result=CPETAssessment(Data)
print(result)

