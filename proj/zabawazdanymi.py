import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

def main(plik):
    df = pd.read_csv(plik, sep=';', header=None, names=["x", "exp(x)", "tExp1", "tExp2", "tExp3", "tExp4"])

    exp = df["exp(x)"]

    for i in range(1, 5):
        error = np.abs((df[f"tExp{i}"] - exp))
        print(f"tExp{i}: {error.mean()}")

main("exp_function.csv")

dane = pd.read_csv("exp_function_dokl.csv", sep=';', header=None, names=["i", "blad"])
plt.plot(dane["i"], dane["blad"])
plt.xlabel("i")
plt.ylabel("blad")
plt.show()