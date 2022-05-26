### Применение фильтра Блума для 20 миллионов ИИН
Файл iin_20m.txt (102 MB) можно скачать по ссылке:
https://drive.google.com/file/d/1SIfp_CRl4cQetc3Kw2jqDcWpF3fYPc2s/view?usp=sharing

MyBloomFilter.java - реализация фильтра Блума, где в качестве хэшей берутся части хэша SHA-384

GoogleBloomFilter.java - небольшая обертка над реализацией фильтра Блума из Google Guava

CalcUtils.java - реализация формул для расчета оптимальных параметров фильтра Блума

OptimalCalc.java - расчет оптимальных параметров для нашей задачи

MemoryTest.java - тестирование различных структур данных для хранения 20 миллионов ИИН
