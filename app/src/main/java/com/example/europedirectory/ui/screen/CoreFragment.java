package com.example.europedirectory.ui.screen;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;

import com.example.europedirectory.App;
import com.example.europedirectory.R;
import com.example.europedirectory.database.AppDataBase;
import com.example.europedirectory.database.Countries;
import com.example.europedirectory.database.CountriesDao;
import com.example.europedirectory.databinding.FragmentCoreBinding;

import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class CoreFragment extends Fragment {

    private FragmentCoreBinding binding;
    String[] descArray = {"Название страны происходит от др.-в.-нем. Ostarrichi (позже — Osterreich) — «восточная страна» (ostar — «восток», richi — «страна»)[9]. Название «Австрия» впервые упоминается в документе от 1 ноября 996 года.\n" + "Австрийский флаг является одним из самых древних государственных символов в мире. Согласно преданию, в 1191 году, во время одной из битв третьего крестового похода, белоснежная рубашка Леопольда V полностью была забрызгана кровью. Когда герцог снял с себя широкий пояс, на рубашке образовалась белая полоса. Сочетание этих цветов стало его знаменем, а в будущем флагом Австрийской Республики.\n" + "В честь Австрии назван астероид (136) Австрия[10], открытый 18 марта 1874 года австрийским астрономом Иоганном Пализой в Австро-Венгерской морской обсерватории в Пуле.","Название государства происходит от словосочетания «Белая Русь», известного с середины XIII века и употреблявшегося по отношению к различным регионам Руси. До конца XV века большинство упоминаний о «Белой Руси» (Alba Russia) происходит из Западной Европы и относится к территории Новгородской республики[22]. По отношению к части современной территории Белоруссии, а именно к подвинской земле (современная Витебская область), название «Белая Русь» впервые стало употребляться с середины XIV века[23]. В XV—XVI веках термин также относился к Московскому государству[24].\n" + "Существует три основных версии происхождения названия «Белая Русь». По одной из них, население, проживавшее на территории нынешней Белоруссии, носило одежду из светлой холщовой ткани. Вкупе со светлыми волосами и глазами это производило впечатление чистоты, света, поэтому и назвали данную часть Руси «Белой». По другой версии, до этой земли практически не доходили татаро-монгольские завоеватели, и термин «Белая Русь» употреблялся в значении «свободная». По третьей версии, «Белой» данную территорию назвали из-за широкого распространения христианства по сравнению с языческой Чёрной Русью[25][26]. С 1620-х годов термин начал закрепляться за восточными (подвинско-поднепровскими) землями Великого княжества Литовского[27]. Для обозначения жителей Белой Руси в этот период употреблялся термин «белорусцы»[25]; одновременно с ним продолжали использоваться политоним «литвины»[28] и этноним «русины»[29].\n" + "Первой административно-территориальной единицей, которая содержала в своём официальном названии термин «Беларусь», было Белорусское генерал-губернаторство (1796) в составе Российской империи[30]. Идею создания самостоятельного государства (не государственных образований), которое имело бы титульное название «Беларусь», выдвинул в конце 1915 года Вацлав Ластовский[27]. Первым государством, которое имело название «Беларусь», стала Белорусская Народная Республика (1918—1919). В 1919 году была образована Белорусская Советская Социалистическая Республика. 19 сентября 1991 года в связи с распадом СССР и образованием суверенного государства новым названием стало «Республика Беларусь»[31]. В начале XX века во время становления белорусского национального движения предлагались и другие варианты названия страны, например, Крывия[32]. По сообщению этнографа Ефима Карского, название «Белоруссия» не было известно простонародью региона[33].","Этимология топонима «Дания» до настоящего времени точно не выяснена и остаётся предметом научных споров; в источниках V—VI вв. упоминается древнегерманское племя даны, жившее на Ютландском п-ове. В IX в. при административном устройстве пограничных земель империи Карла Великого была образована Danmark — «датская марка» (марка — др.-верх.-нем. «граница, пограничные земли»), ставшая в XI в. государством Danmark[13].","Топоним «Албания» происходит от средневекового латинского названия страны. Возможно, он произошёл от наименования иллирийского племени албаны (алб. Albanët), отмеченного Птолемеем, географом и астрономом из Александрии, составившим карту в 150 году нашей эры, на которой был показан город Албанополис, расположенный к северо-востоку от города Дуррес[11]. От него, вероятно, произошло название средневекового поселения под названием Албанон или Арбанон, хотя нет никакой уверенности, что оно располагалось на месте прежнего Албанополиса[12]. В своей истории, написанной в XI веке, византийский историк Михаил Атталиат впервые упоминает об албаноях, участвовавших в восстании против Константинополя в 1043 году, и об арбанитаях как подданных герцога Диррахия. В Средние века албанцы называли свою страну Арбери (алб. Arbëri) или Арбени (алб. Arbëni), а себя — арберешами (алб. Arbëreshë) или арбенешами (алб. Arbëneshë)[13][14].\n" + "Ныне албанцы называют свою страну Shqipëri или Shqipëria. Ещё в XVII веке топоним Shqipëria и этнический катойконим Shqiptarë постепенно заменили, соответственно, Arbëria и Arbëresh. Shqipëria и Shqiptarë часто объясняются как «Земля орлов» и «дети орлов»[15][16]; по одной из версий, Shqipëria происходит от албанского слова shqip — «излагать мысль»[17]. Славист А. М. Селищев утверждал, что исток этого корня — слово shqe, означающее «славяне» (Shqerí — от албанского shqa < *skla, мн. ч. — shqe) и является следствием славянской колонизации Балкан в VI—VII веках[18].","Исторически Бельгия была частью области, известной как Нидерланды (нидерл. Nederlanden — Нижние земли) — региона, несколько более крупного, чем современный Бенилюкс, в который также входили части Северной Франции и Западной Германии. Название страны происходит от этнонима кельтского племени — белги, которое дало название римской провинции Белгика (лат. Gallia Belgica)[9], образованной в 16 году до н. э.","Название страны происходит от названия тюркских племён булгары, населявших с IV века степи Северного Причерноморья до Каспия и Северного Кавказа и мигрировавших во 2-й половине VII века частично в Подунавье, а позднее — в Среднее Поволжье и ряд других регионов. Некоторые историки ставят под вопрос идентификацию булгар как тюркского племени, высказывая гипотезу об их североиранском происхождении[11][12]. Этноним «булгары», возможно, возник из прототюркского слова bulģha («смешивать», «встряхивать», «перемешивать») и его производного bulgak («восстание», «беспорядок»)[13]. Альтернативные этимологии выводят происхождение этнонима из монгольского bulğarak («отделить») или от соединения пратюркского bel («пять») и gur («стрела» в смысле «племя»), предполагаемого разделения утигуров или оногуров («десять племён»)[14].\n" + "Альтернативная гипотеза происхождения названия страны связана с особенностями произношения названия реки Волга, у берегов которой обитали эти племена, постепенно трансформировавшегося: Volga — Volgarii — Volgaria — Bolgaria — Bulgaria","Как гласят исландские саги, остров был открыт викингами в 60-х годах IX века и одним из первооткрывателей, Флоки, был назван Ísland «ледяная страна» (от ís «лёд», land «страна») за обилие льдов, покрывающих остров; в то же время другой викинг, высадившийся на противоположном берегу, назвал его Snjøland — «снежная страна»[14].\n" + "Согласно другой гипотезе, остров был изначально назван Гардарсхоульмюр («остров Гардара») — по имени шведского викинга Гардара Сваварсона, которого считают первым скандинавом, жившим в Исландии. Тем не менее за островом закрепилось название Ísland, хорошо подходящее из-за его природных условий[15].","Точное происхождение топонима «Андорра» неизвестно, среди лингвистов выдвинут ряд гипотез на этот счёт. В частности, существует точка зрения, что название «Андорра» происходит от наварро-арагонского слова andurrial, что означает «земля, покрытая кустарником» или «лесистая местность»[9], поскольку долины Пиренеев были покрыты большими лесными массивами.","Клавдий Птолемей в своём труде «Альмагест» (147—148 н. э.) называет больший остров «Большой Бретанией» (др.-греч. μεγάλης Βρεττανίας), а Ирландию — «Малой Бретанией». В своей более поздней работе «География» (150 г. н. э.) он называет эти острова «Альвион», «Иверниа» и «Мона» (остров Мэн). Предполагается, что эти названия не были известны ему во время написания «Альмагеста». Название «Альбион», видимо, вышло из употребления через некоторое время после завоевания островов римлянами, и остров стали называть «Великобританией».\n" + "После англосаксонского периода название «Британия» стало упоминаться только как исторический термин. Гальфрид Монмутский в своём полулегендарном сочинении «История королей Британии» Великобританию называет «Большой Британнией» («Большая Британия»), которую отделяет от «Малой Британнии» («Меньшая Британия») — область в континентальной Европе, где селились кельтские переселенцы с Британских островов в V—VI веке. Название «Великобритания» впервые было использовано официально в 1474 году — в письме с предложением о браке между Сесили дочери Эдуарда IV из Англии и Джеймсом, сыном Джеймса III из Шотландии, в котором сказано «этот благородный остров, называемый Великобританией». Официально это слово прозвучало опять в 1604 году, когда король Яков VI провозгласил себя «Королём Великобритании, Франции и Ирландии».","В русском языке слово «венгр» — заимствование из польск. węgier «венгр» из праслав. *ǫgъrinъ (др.-рус. ѹгринъ, укр. у́горець, белор. вугорац, сербск.-ст.‑слав. ѫгринъ, мн. ѫгре, серб. у̀гар, род. п. у̀гра, также у̀грин, болг. унгарци, хорв. ugor, словен. vogar, vogrin, чеш. uher, словацк. uhor, польск. węgier, węgrzyn, лит. veñgras)[8].\n" + "В других индоевропейских языках тоже имеется это слово: лат. Ungari, Ungri, греч. Οὑγγρικός, Οὖγγροι, фр. hongrois, нем. Ungar(n), англ. Hungarian(s), швед. ungrare. Все эти экзоэтнонимы произошли из булг. on ogur, тюрк. on oguz «десять огузских племён»[8]. Начальное h- развилось, вероятно, под влиянием этнонима Hunni «гунны». В средние века Венгрию долго называли «королевством гуннов», так она упоминается в эпическом романе «Песнь о Нибелунгах».","Название «Латвия» пришло в латышский язык из литовского, в котором оно образовалось от этнонима латышей — латвяй (лит. latviai). В латышскую литературу термин «Латвия» ввёл поэт Аусеклис[13].\n" + "Впервые похожее название в форме Леттия (Lettia, Letthia, Leththia) встречается в «Хронике» Генриха Латвийского (1209), при описании военных действий немецких рыцарей против ерсикского князя Всеволода (Висвалдиса), первоначально для обозначения населённых латгалами территорий (Герсикское и Кукенойсское княжества). В 1211 году, при разделе этих земель между Рижским архиепископом и Ливонским орденом, все эти земли стали называть Леттия (Letthia). Это название впервые упомянуто в папской булле от 20 октября 1210 года и впоследствии регулярно встречалось в документах до XIV века, а в XV веке было окончательно вытеснено наименованием «Ливония» (средненемецкое Lyflant, Ifland)[13].\n" + "Слово «Латвия» для наименования всех латышских территорий впервые употребил вильяндский священник Дионисий Фабрициус в своей хронике «Livonicae historiae compediosa series», оконченной в 1611 году. Затем термин «земля латышей» упоминали священники: Георг Манцель (latviešu zeme, Lettus, 1638), Якоб Ланге (latviska zeme, Lexicon, 1777), Старший Стендер упоминал словосочетание Latvju zeme (Lexicon, 1789)[13].\n" + "В широкое употребление термин вошёл после отмены крепостного права в Лифляндской и Курляндской губерниях, когда в среде говоривших по-латышски крестьян стало формироваться национальное самосознание. Юрис Алунанс в 1857 году предложил использовать название «Латва», а затем, по аналогии с литовским языком, добавил к нему суффикс и окончания -ija. Попавшие под влияние немцев латыши вначале использовали термин «Балтия», производный от неологизма Baltenland, заменившего старейшее понятие Ostseeprovinzen. В торжественной песне Карлиса Бауманиса «Боже, благослови Латвию!» первоначально говорилось не о Латвии, а о Балтии. Также Балтия фигурировала наравне с Латвией в эпосе Андрея Пумпура «Лачплесис»[13].\n" + "Политическое звучание термин «Латвия» приобрёл во время революции 1905 года, а затем он получил хождение за рубежом усилиями эмигрантов (Райнис, К. Скалбе). Окончательно он утвердился во время Первой мировой войны, в связи с формированием частей латышских стрелков и боями за независимость[13].","Название страны состоит из слов, обозначающих исторические области: Босния и Герцеговина. В аббревиатуре — БиГ. Босния под названием «Босона» (др.-греч. Βοσωνα) впервые упоминается в сочинении «Об управлении империей», написанном Константином Багрянородным около 950 года[11]. Топоним «Босния» имеет, предположительно, дославянское происхождение[12]; происходит от реки Босны[13], на берегах которой зародилось Боснийское государство. Название Герцеговины происходит от венг. herceg — «воевода»[13]. Исторически связано с боснийским феодалом Степаном Вукчичем, который в 1448 году принял звание воеводы или герцога[14] святого Саввы, отчего впоследствии его владения, составлявшие средневековую область Хум, получили название Герцеговины[15]. Во времена турецкого владычества название закрепилось за образованным на хумских землях Герцеговинским санджаком (тур. Hersek Sancağı)[16]. Герцеговина была выделена в самостоятельную административную единицу турками в 1833 году в связи с волнениями в Боснии[17]. В 1878 году Босния и Герцеговина в соответствии с Берлинским трактатом была оккупирована Австро-Венгрией и в 1908 году вошла в состав империи в качестве отдельной самоуправляющейся территории под верховным управлением Австрии и Венгрии. В 1910 году была принята конституция Боснии и Герцеговины. Аннексия Боснии Австро-Венгрией послужила причиной Боснийского кризиса.\n" + "После распада Югославии, в 1992—1997 годах официальное название государства было «Республика Босния и Герцеговина». После Дейтонских соглашений 1995 года и принятия новой конституции официальное название было изменено на «Босния и Герцеговина».","Русское название «Германия» происходит от латинского «Germania», которое восходит к сочинениям античных авторов I века новой эры и образовано от этнонима «германцы» (лат. Germanus). Впервые название было употреблено Юлием Цезарем в «Записках о галльской войне» относительно племён, проживавших за Рейном. Само слово, вероятно, имеет нелатинские корни и происходит от кельтского «gair» («сосед»)[21].\n" + "По-немецки государство называется «Deutschland» (от прагерм. Þeudiskaz). «Deutsch» (от прагерм. Þeodisk) первоначально означало «имеющий отношение к народу» и подразумевало в первую очередь язык[22]. «Land» означает «земля, страна». Современная форма написания названия страны используется с XV века.\n" + "Этноним «немец» происходит от «немой». Так на Руси называли иноземцев, не знающих или плохо знающих язык, и потому по большей части молчавших.\n" + "В СССР на русском языке использовалось название «Федеративная Республика Германии». Такая форма, например, использована в «Большой советской энциклопедии». После присоединения в 1990 году Германской Демократической Республики к Федеративной Республике Германия было принято решение по взаимной договорённости правительств Германии и России не склонять слово «Германия» в официальном названии государства[23][24]. Правильно: «Федеративная Республика Германия»[25] (а не «Федеративная Республика Германии»). Сокращение «ФРГ» активно использовалось в СССР и в ГДР и сегодня используется в русском языке. В самой Германии в официальном языке это сокращение (BRD) использовать не принято и употребляется лишь полная форма названия или фраза «федеративная республика» (нем. Bundesrepublik), когда понятно, что речь идёт об этой стране.\n" + "От топонима Германия названы астероид (241) Германия, открытый в 1884 году немецким астрономом К. Лютером, и элемент периодической системы химических элементов германий, открытый в 1886 году немецким химиком К. Винклером.","Название страны Moldova произошло от названия реки Молдова, ныне протекающей на северо-востоке Румынии. Согласно легенде, именно в бассейне Молдовы находился первоначальный центр Молдавского княжества[32].","Этимология слова «Литва» точно не известна, при этом существует множество версий, ни одна из которых не получила всеобщего признания. Корень «лит» и его варианты «лет»/«лют» допускают различные толкования как в балтских и славянских, так и в других индоевропейских языках. Так, например, существуют созвучные топонимы на территории Словакии «Lytva» и Румынии «Litua», известные с XI—XII веков[11]. По мнению Е. Поспелова, топоним образован от древнего названия реки Летава (Lietavà от лит. lieti «лить», русское «Летаука»). Феодальное княжество, по землям которого протекала эта река, со временем заняло ведущее положение и название было распространено на всё государство. В «Повести временных лет» (XII век) упоминается этноним «литва», полностью совпадающий с названием местности «Литва» и по смыслу (территория, где живёт литва), и по форме[12].","Официальное название «Ватикан» впервые было использовано в Латеранских соглашениях, заключённых 11 февраля 1929 года между Святым Престолом и правительством Италии во главе с Б. Муссолини, которые установили статус современного города-государства. Название было взято от названия Ватиканского холма (итал. Monte Vaticano), на котором расположено государство. Название же Ватиканского холма, вероятно, появилось от этрусского названия города «Ватикум», в настоящее время не существующего. Согласно легендам, на этом месте этрусские прорицатели (а позже — римские авгуры) провозглашали свои предсказания — «ватицинации» (лат. vaticinatio — «предсказание», «пророчество»)[16]. Исторически (до появления государства Ватикан) слово «ватикан» имело значение «дворец папы»[17].\n" + "Официальное итальянское название Ватикана (итал. Stato della Città del Vaticano) означает в буквальном переводе «Государство Го́рода Ватикан». Хотя Святой Престол (который не идентичен Ватикану) и католическая церковь используют в официальных документах церковную латынь, Ватикан в своей текущей деятельности официально использует итальянский язык. Латинское название государства лат. Status Civitatis Vaticanæ[18][19] используется в официальных документах не только Святым Престолом, но и в большинстве официальных церковных и папских документов.","Название государства на современном ирландском языке (Eire[10]) происходит от древнеирландского Eriu, или Эриу — имени богини в ирландской мифологии[11].\n" + "Четвёртая статья Конституции Ирландии (принятой в 1937 году) гласит: «Название государства — Éire, или, по-английски, Ireland»[12]. В 1947 году было принято название Republic of Ireland как описание государства (Description of the State); названием же его по-прежнему осталось просто Ireland. Это связано с заявленными в конституции претензиями на весь остров: «Принадлежащая народу территория состоит из всего острова Ирландия, прилегающих к нему островов и территориального моря» (ст. 2; с 1998 года, в результате Белфастского соглашения, текст заменён на более нейтральный[какой?]). Тем не менее в разных сферах — официальных и неофициальных — для отличия государства от британской Северной Ирландии и острова в целом широко используется наименование Republic of Ireland.","После введения официального названия — «Rzeczpospolita Polska» — его некоторое время переводили на русский язык как Польская Республика, потому что слово Polska одновременно значит и «Польша» и «Польская». Затем последовало разъяснение МИД Польши о том, что адекватным переводом является «Республика Польша». В официальном названии страны используется не современное польское слово «republika» (республика), а устаревшее — «rzeczpospolita» (Речь Посполитая), которое является дословным переводом на польский язык латинского термина «rēs pūblica» (общественное дело). Русское название «Польша» восходит к местному падежу единственного числа w Polszcze (совр. польск. w Polsce) от польск. Polska — субстантивированное прилагательное «польская» от ziemia polska — «земля польская», то есть «земля полян» (название племени, в свою очередь, происходит от слова «поле»)","Название страны происходит от древнескандинавского Norreweg — «северный путь», которое первоначально относилось к прибрежному морскому пути, по которому норманны выходили в северные моря. Впоследствии этим названием стали обозначать западное побережье Скандинавского полуострова вдоль морского пути, а затем и возникшее здесь государство[9]. Страна имеет два названия, на обеих версиях норвежского языка — Norge на букмоле и Noreg на нюношке.","Слово «Греция» имеет латинское происхождение и в греческом языке не используется. Самоназвание греками своей страны — Элла́да (Эллас, греч. Ελλάδα)[16]. Изначально, согласно «Илиаде» Гомера, Эллада — название области в южной Фессалии — Фтиотиды, постепенно распространилось на всю Грецию[17]. С принятием термина эллин общим для обозначения всех греков, Эллада стала собирательным именем для всей материковой Греции, а затем и всей Греции, включая архипелаги, острова и области в Малой Азии (в противоположность исторической Великой Греции, расположенной в Южной Италии)[18].\n" + "В настоящее время в Греции слово Эллада является официальным самоназванием, а слова грек (лат. Graecus) или Греция (лат. Graecia) не признаются населением и употребляются только в общении с иностранцами. В других странах Эллада часто служит синонимом понятия Древняя Греция.","Территория Лихтенштейна с 15 года до н. э. входила в римскую провинцию Реция. Франки вторглись в страну в 536 году. Позже, при Карле Великом, с должности губернатора был смещён епископ, и на эту должность стали назначать светских правителей. Район находился под властью Каролингов до 911 года, когда Восточно-Франкское королевство распалось на большие и малые герцогства.\n" + "В пределах герцогства Швабия на территории нынешнего Лихтенштейна находились феодальные владения Шелленберг и Вадуц, вошедшие затем в состав Священной Римской империи. В 1507 году император Максимилиан предоставил Вадуцу особые права и привилегии, включая суверенитет и сбор налогов. Эти права были переданы австрийскому семейству Лихтенштейнов.","Первое письменное упоминание названия «Росия» на греческом языке (греч. Ρωσία) датировано серединой X века и встречается в сочинениях византийского императора Константина Багрянородного «О церемониях» и «Об управлении империей» для обозначения Руси[37]. В кириллической записи слово «Росия» (Рωсїѧ) было впервые употреблено 24 апреля 1387 года[38] в собственноручной приписке митрополита Киприана к переписанной им «Лествице» Иоанна Синайского, где он именует себя «митрополитом Кыевскым и всея Росия»[39]. В XV—XVI веках эллинизированное название «Росия» закрепилось за той частью русских земель, которая была объединена в единое государство под началом Великого княжества Московского: так, Иоанн де Галонифонтибус использует это название в указанном значении в 1404 году[40], а Иван III назван «российским государем» в грамоте крымского хана в 1474 году[41].\n" + "В 1547 году, после венчания на царство Ивана IV Васильевича, Московское государство стало также именоваться как Российское царство[42]. Современное написание слова — с двумя буквами «с» — появилось с середины XVII века и окончательно закрепилось при Петре I.\n" + "По завершении Северной войны, 22 октября (2 ноября) 1721 года Пётр I был провозглашён императором Всероссийским. После этого государство стали официально называть Российской империей[43].\n" + "1 (14) сентября 1917 года, в период между Февральской и Октябрьской революциями, Россия была объявлена республикой, а с 19 июля 1918 года начала официально именоваться Российской Социалистической Федеративной Советской Республикой (РСФСР; в 1936 году слова «Социалистическая» и «Советская» в названии были переставлены местами). С 1922 по 1991 года РСФСР входила в состав СССР, который неформально (особенно за рубежом) часто именовался Россией. В период распада Советского Союза 25 декабря 1991 года РСФСР получила новое название — Российская Федерация","Название страны в русском и многих других языках происходит от шведского Finland («земля охотников» — от древнескандинавского fin «охотник», и шведского land — «земля, страна»[15]). В Саге об Инглингах (XIII век), написанной на древнеисландском языке, упоминается топоним Finnland.\n" + "Финское название страны — Suomi. Впервые оно упоминается на страницах новгородских летописей в форме Сумь (с начала XII века).\n" + "Существует несколько версий происхождения этого названия:\n" + "Предполагается, что некогда существовала местность под названием Suomaa (фин. suo «болото», maa «земля»; дословно: «земля болот»[15]). Переселенцы из этой области перенесли название своей родины в юго-западную Финляндию, которая стала называться Suomi.\n" + "Ещё одна версия гласит, что «суоми» — искажённое «саами» — самоназвание народа, жившего здесь до прихода финских племён.\n" + "Также существует версия, что финское самоназвание suomi имеет эстонское происхождение (от эст. soo — «болото»)","В течение столетий возникало множество гипотез по поводу этимологии названия «Испания». Считается, что оно происходит от римского топонима Hispania, происхождение которого остаётся не до конца выясненным, хотя документально подтверждено, что финикийцы и карфагеняне именовали регион Spania, поэтому наиболее распространённой версией этимологии является семитско-финикийская","Древнейшие следы обитания людей на территории Люксембурга относятся к верхнему палеолиту и датируются около 35 000 годом до н. э. Древнейшие артефакты этого периода — украшенные кости, обнаруженные в Этрингене[8].\n" + "Постоянные поселения с домами появляются в эпоху неолита, в 5 тысячелетии до н. э. Следы таких поселений обнаружены на юге Люксембурга, в городе Аспельт[sv], а также в коммунах Вейлер-ла-Тур, Гревенмахер и Дикирх. Каркас жилищ состоял из древесных стволов, стены — из покрытой глиной плетёной лозы, а крыши были покрыты тростником или соломой[9]. Неолитическая керамика обнаружена близ Ремершена","Название страны происходит от этнонима «румын».","Новообразование — «эсто́нец»[12], до XVIII—XIX веков эстонцы называли себя maarahvas, что буквально значит «народ земли», то есть занимающийся земледелием[16]. Термин eestlane пришёл из латыни (Aestii), так названо Тацитом в «Германии» балтийское племя[12], населяющее дальний берег Балтийского моря[b].\n" + "Древние скандинавские саги содержат упоминание о земле под названием Эйстланд (Eistland) — так Эстония до настоящего времени называется на исландском языке, что близко к датскому, немецкому, нидерландскому, шведскому и норвежскому варианту названия — Эстланд (Estland). Ранние источники на латинском языке также содержат версии названия территории Эстия и Гестия (Estia и Hestia)[17].\n" + "После провозглашения независимости в 1918 году страна получила название «Эстония» (Esthonia), под этим названием она вступила в 1921 году в Лигу Наций[18][19]. По конституциям 1920 и 1934 годов страна именовалась Эстонской Республикой. В 1940 году, с присоединением к СССР, была образована Эстонская Советская Социалистическая Республика, а после распада СССР в 1991 году было восстановлено досоветское название[20].\n" + "Топоним Estland/Eistland связывают с древнескандинавским aust, austr, что означает «восток»","Происхождение слова Italia точно неизвестно. Согласно наиболее распространённой точке зрения, термин пришёл из Греции и означает «страна телят»[11][12][13]. Бык был символом народов, населявших юг Италии, и часто изображался бодающим римскую Волчицу. Изначально название Italia применялось только к той части территории, которую теперь занимает Южная Италия (современная провинция Калабрия).","О происхождении и значении названия Монако не существует единого мнения. Согласно одной из гипотез, в VI веке до н. э., лигурийские племена основали на этом месте колонию Монойкос (Monoikos), название которой происходит от имени греческого мифологического героя Геракла[9] — «Портус Геркулес Монойки», то есть «порт одинокого Геракла». Римский император Юлиан Отступник также писал об участии Геракла в сооружении порта Монако и прибрежной дороги[10]. На этой дороге было размещено множество алтарей, посвящённых Гераклу, а на скале Монако[en] был сооружён храм в его честь. Monoeci означает «одинокий», а Monoikos означает «уединённый дом», что может означать храм Геракла на скале или изолированное сообщество жителей, населявших территорию вокруг скалы",""};
    String[] nameArray = {"Австрия", "Белоруссия", "Дания", "Албания", "Бельгия", "Болгария", "Исландия", "Андорра", "Великобритания", "Венгрия", "Латвия", "Босния и Герцеговина", "Германия", "Молдавия", "Литва", "Ватикан", "Ирландия", "Польша", "Норвегия", "Греция", "Лихтенштейн", "Россия", "Финляндия", "Испания", "Люксембург", "Румыния", "Эстония", "Италия", "Монако"};
    String[] urlArray = {"https://ru.wikipedia.org/wiki/%D0%90%D0%B2%D1%81%D1%82%D1%80%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%91%D0%B5%D0%BB%D0%BE%D1%80%D1%83%D1%81%D1%81%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%94%D0%B0%D0%BD%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B1%D0%B0%D0%BD%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%91%D0%B5%D0%BB%D1%8C%D0%B3%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%91%D0%BE%D0%BB%D0%B3%D0%B0%D1%80%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%98%D1%81%D0%BB%D0%B0%D0%BD%D0%B4%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%90%D0%BD%D0%B4%D0%BE%D1%80%D1%80%D0%B0","https://ru.wikipedia.org/wiki/%D0%92%D0%B5%D0%BB%D0%B8%D0%BA%D0%BE%D0%B1%D1%80%D0%B8%D1%82%D0%B0%D0%BD%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%92%D0%B5%D0%BD%D0%B3%D1%80%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%9B%D0%B0%D1%82%D0%B2%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%91%D0%BE%D1%81%D0%BD%D0%B8%D1%8F_%D0%B8_%D0%93%D0%B5%D1%80%D1%86%D0%B5%D0%B3%D0%BE%D0%B2%D0%B8%D0%BD%D0%B0","https://ru.wikipedia.org/wiki/%D0%93%D0%B5%D1%80%D0%BC%D0%B0%D0%BD%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%9C%D0%BE%D0%BB%D0%B4%D0%B0%D0%B2%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%9B%D0%B8%D1%82%D0%B2%D0%B0","https://ru.wikipedia.org/wiki/%D0%92%D0%B0%D1%82%D0%B8%D0%BA%D0%B0%D0%BD","https://ru.wikipedia.org/wiki/%D0%98%D1%80%D0%BB%D0%B0%D0%BD%D0%B4%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%9F%D0%BE%D0%BB%D1%8C%D1%88%D0%B0","https://ru.wikipedia.org/wiki/%D0%9D%D0%BE%D1%80%D0%B2%D0%B5%D0%B3%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%93%D1%80%D0%B5%D1%86%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%9B%D0%B8%D1%85%D1%82%D0%B5%D0%BD%D1%88%D1%82%D0%B5%D0%B9%D0%BD","https://ru.wikipedia.org/wiki/%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%A4%D0%B8%D0%BD%D0%BB%D1%8F%D0%BD%D0%B4%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%98%D1%81%D0%BF%D0%B0%D0%BD%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%9B%D1%8E%D0%BA%D1%81%D0%B5%D0%BC%D0%B1%D1%83%D1%80%D0%B3","https://ru.wikipedia.org/wiki/%D0%A0%D1%83%D0%BC%D1%8B%D0%BD%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%AD%D1%81%D1%82%D0%BE%D0%BD%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%98%D1%82%D0%B0%D0%BB%D0%B8%D1%8F","https://ru.wikipedia.org/wiki/%D0%9C%D0%BE%D0%BD%D0%B0%D0%BA%D0%BE"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCoreBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        AppDataBase dataBase = App.getInstance().getDatabase();
        CountriesDao countriesDao = dataBase.countrysDao();

        binding.downloadButton.setOnClickListener(v -> {
            ObservableOnSubscribe<Countries> zxc = emitter -> {
                for (int i = 0; i < nameArray.length; i++) {
                    emitter.onNext(new Countries(nameArray[i],descArray[i],urlArray[i]));
                }
            };
            Observable<Countries> observable = Observable.create(zxc);
            observable.subscribeOn(Schedulers.io()).subscribe(countriesDao::insert, throwable -> Log.d("TAG", Objects.requireNonNull(throwable.getMessage())));
            binding.downloadButton.setVisibility(View.INVISIBLE);
        });
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                countriesDao.getByName(query).subscribeOn(Schedulers.io()).subscribe(new DisposableSingleObserver<Countries>() {
                    @Override
                    public void onSuccess(Countries countries) {
                        Bundle bundle = new Bundle();
                        bundle.putString("1", countries.getUrl());
                        bundle.putString("2", countries.getName());
                        bundle.putString("3", countries.getDesc());
                        DetailsFragment detailsFragment = new DetailsFragment();
                        detailsFragment.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.placeHolder, detailsFragment).addToBackStack("perv").commit();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", e.getMessage());
                    }
                });

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return view;
    }
}