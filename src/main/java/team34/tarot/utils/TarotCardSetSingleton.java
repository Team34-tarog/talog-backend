package team34.tarot.utils;

public class TarotCardSetSingleton {

	private static final TarotCardSetSingleton standard = new TarotCardSetSingleton();
	private TarotCard[] tarotCardSet;

	private TarotCardSetSingleton() {
		tarotCardSet = new TarotCard[10];

		tarotCardSet[0] = new TarotCard(1, "The Magician", "major",
						"신성한 의지, 영적과 물질적 세계의 연결, 그리고 지속적인 정신적 성장을 상징합니다. 이 카드는 자기 신뢰와 초기의 행동, 창조적인 힘, 그리고 변화의 가능성을 나타냅니다. 그것은 또한 개인이 영혼의 힘과 선물을 가지고 있으며, 이들을 적절히 사용하여 세상에 영향을 미칠 수 있다는 메시지를 전달합니다.",
						"A youthful figure in the robe of a magician, having the countenance of divine Apollo, with smile of confidence and shining eyes. Above his head is the mysterious sign of the Holy Spirit, the sign of life, like an endless cord, forming the figure 8 in a horizontal position . About his waist is a serpent-cincture, the serpent appearing to devour its own tail. This is familiar to most as a conventional symbol of eternity, but here it indicates more especially the eternity of attainment in the spirit. In the Magician's right hand is a wand raised towards heaven, while the left hand is pointing to the earth. This dual sign is known in very high grades of the Instituted Mysteries; it shews the descent of grace, virtue and light, drawn from things above and derived to things below. The suggestion throughout is therefore the possession and communication of the Powers and Gifts of the Spirit. On the table in front of the Magician are the symbols of the four Tarot suits, signifying the elements of natural life, which lie like counters before the adept, and he adapts them as he wills. Beneath are roses and lilies, the flos campi and lilium convallium, changed into garden flowers, to shew the culture of aspiration. This card signifies the divine motive in man, reflecting God, the will in the liberation of its union with that which is above. It is also the unity of individual being on all planes, and in a very high sense it is thought, in the fixation thereof. With further reference to what I have called the sign of life and its connexion with the number 8, it may be remembered that Christian Gnosticism speaks of rebirth in Christ as a change \\\"unto the Ogdoad.\\\" The mystic number is termed Jerusalem above, the Land flowing with Milk and Honey, the Holy Spirit and the Land of the Lord. According to Martinism, 8 is the number of Christ.");
		tarotCardSet[1] = new TarotCard(15, "The Devil", "major",
						"우리의 낮은 욕구, 물질적인 삶의 사슬, 그리고 자유를 위한 싸움을 상징합니다. 이 카드는 과도한 욕망이나 중독에 대한 통제 감각을 잃어가는 상황을 나타냅니다. 그러나 이는 영원한 노예 상태를 의미하는 것은 아니며, 그것은 우리의 '동물적 본성'이 우리를 지배하도록 허용하는 선택에 대한 상징일 뿐입니다.",
						"The design is an accommodation, mean or harmony, between several motives mentioned in the first part. The Horned Goat of Mendes, with wings like those of a bat, is standing on an altar. At the pit of the stomach there is the sign of Mercury. The right hand is upraised and extended, being the reverse of that benediction which is given by the Hierophant in the fifth card. In the left hand there is a great flaming torch, inverted towards the earth. A reversed pentagram is on the forehead. There is a ring in front of the altar, from which two chains are carried to the necks of two figures, male and female. These are analogous with those of the fifth card, as if Adam and Eve after the Fall. Hereof is the chain and fatality of the material life.\\nThe figures are tailed, to signify the animal nature, but there is human intelligence in the faces, and he who is exalted above them is not to be their master for ever. Even now, he is also a bondsman, sustained by the evil that is in him and blind to the liberty of service. With more than his usual derision for the arts which he pretended to respect and interpret as a master therein, Éliphas Lévi affirms that the Baphometic figure is occult science and magic. Another commentator says that in the Divine world it signifies predestination, but there is no correspondence in that world with the things which below are of the brute. What it does signify is the Dweller on the Threshold without the Mystical Garden when those are driven forth therefrom who have eaten the forbidden fruit.");
		tarotCardSet[2] = new TarotCard(16, "The Tower", "major",
						"강렬하게 변화와 해방을 상징합니다. 이는 고정관념이나 거짓된 이해가 붕괴되는 것을 나타냅니다. 이 카드는 때로는 자만이나 오만함의 벌을 상징하기도 합니다. 물질적이거나 동물적 상태로의 추락과 지적인 면에서의 파괴를 의미할 수 있습니다. 깊게 보면, 세상의 특정 단계나 체제의 종말을 나타내기도 합니다.",
						"Occult explanations attached to this card are meagre and mostly disconcerting. It is idle to indicate that it depicts min in all its aspects, because it bears this evidence on the surface. It is said further that it contains the first allusion to a material building, but I do not conceive that the Tower is more or less material than the pillars which we have met with in three previous cases. I see nothing to warrant Papus in supposing that it is literally the fall of Adam, but there is more in favour of his alternative--that it signifies the materialization of the spiritual word. The bibliographer Christian imagines that it is the downfall of the mind, seeking to penetrate the mystery of God. I agree rather with Grand Orient that it is the ruin of the House of We, when evil has prevailed therein, and above all that it is the rending of a House of Doctrine. I understand that the reference is, however, to a House of Falsehood. It illustrates also in the most comprehensive way the old truth that \\\"except the Lord build the house, they labour in vain that build it.\\\"\\nThere is a sense in which the catastrophe is a reflection from the previous card, but not on the side of the symbolism which I have tried to indicate therein. It is more correctly a question of analogy; one is concerned with the fall into the material and animal state, while the other signifies destruction on the intellectual side. The Tower has been spoken of as the chastisement of pride and the intellect overwhelmed in the attempt to penetrate the Mystery of God; but in neither case do these explanations account for the two persons who are the living sufferers. The one is the literal word made void and the other its false interpretation. In yet a deeper sense, it may signify also the end of a dispensation, but there is no possibility here for the consideration of this involved question.");
		tarotCardSet[3] = new TarotCard(21, "The World", "major",
						"이 카드는 우주의 완성과 종말, 그리고 신의 시각을 인식한 영혼의 상태를 상징합니다. 이것은 본질적으로 세상이 가장 완벽한 상태로 복원됐을 때의 상태를 의미하며, 특히 모든 것이 좋게 선언된 과거의 시점을 이야기합니다. 마지막으로, 이 카드는 마법사의 왕관으로 여겨지기도 합니다.",
						"As this final message of the Major Trumps is unchanged--and indeed unchangeable--in respect of its design, it has been partly described already regarding its deeper sense. It represents also the perfection and end of the Cosmos, the secret which is within it, the rapture of the universe when it understands itself in God. It is further the state of the soul in the consciousness of Divine Vision, reflected from the self-knowing spirit. But these meanings are without prejudice to that which I have said concerning it on the material side.\\nIt has more than one message on the macrocosmic side and is, for example, the state of the restored world when the law of manifestation shall have been carried to the highest degree of natural perfection. But it is perhaps more especially a story of the past, referring to that day when all was declared to be good, when the morning stars sang together and all the Sons of God shouted for joy. One of the worst explanations concerning it is that the figure symbolizes the Magus when he has reached the highest degree of initiation; another account says that it represents the absolute, which is ridiculous. The figure has been said to stand for Truth, which is, however, more properly allocated to the seventeenth card. Lastly, it has been called the Crown of the Magi.");
		tarotCardSet[4] = new TarotCard(28, "Seven of Cups", "cups",
						"많은 선택과 상상력의 결과를 나타냅니다. 그러나 이 선택들은 현실적이지 않거나 지나치게 허상적일 수 있으며, 영구적인 결과나 현실적인 성취를 나타내지 않을 수 있습니다. 이 카드는 우리에게 많은 가능성을 제시하지만, 현실과 연결하여 실제로 이뤄낼 필요가 있는지를 신중하게 고려해야 함을 알려줍니다.",
						"Fairy favours, images of reflection, sentiment, imagination, things seen in the glass of contemplation; some attainment in these degrees, but nothing permanent or substantial is suggested.;Strange chalices of vision, but the images are more especially those of the fantastic spirit.");
		tarotCardSet[5] = new TarotCard(29, "Eight of Cups", "cups",
						"일시적인 만족을 떠나고 새로운 방향을 찾는 의미를 가지고 있습니다. 이 카드는 어떤 문제나 상황에 대한 감소, 중요성 감소, 또는 사소한 결과를 나타낼 수 있습니다. 주인공은 자신의 행복이나 이전의 관심사를 떠나며, 새로운 여정을 시작하는 모습입니다. 이 카드는 삶의 변화와 내적 성장을 상징하며, 현재의 상황에서 벗어나 새로운 가능성을 모색하고자 하는 욕구를 나타냅니다.",
						"The card speaks for itself on the surface, but other readings are entirely antithetical--giving joy, mildness, timidity, honour, modesty. In practice, it is usually found that the card shews the decline of a matter, or that a matter which has been thought to be important is really of slight consequence--either for good or evil.;A man of dejected aspect is deserting the cups of his felicity, enterprise, undertaking or previous concern.");
		tarotCardSet[6] = new TarotCard(40, "Five of Wands", "wands",
						"이 카드는 모방과 경쟁을 상징합니다. 가짜 싸움과 같은 모방 전투를 나타내며, 부와 행운을 찾아 열심히 경쟁하고 투쟁하는 모습을 보여줍니다. 이 카드는 인생의 전투와 관련이 있으며, 금, 이익, 풍요로움을 나타낼 수도 있습니다. 이는 또한 젊은이들이 지팡이를 휘두르며 모방 전투를 벌이는 모습을 보여줍니다.",
						"Imitation, as, for example, sham fight, but also the strenuous competition and struggle of the search after riches and fortune. In this sense it connects with the battle of life. Hence some attributions say that it is a card of gold, gain, opulence.;A posse of youths, who are brandishing staves, as if in sport or strife. It is mimic warfare, and hereto correspond the");
		tarotCardSet[7] = new TarotCard(43, "Eight of Wands", "wands",
						"이 카드는 활동과 역동성을 상징하며, 목표를 향한 신속한 진행과 성공을 암시합니다. 그것은 희망과 기대감이 크고 빠른 속도로 행복한 결과에 다가가는 것을 나타냅니다. 이 카드는 또한 움직임과 전진을 상징하며, 사랑의 화살도 표현할 수 있습니다.",
						"Activity in undertakings, the path of such activity, swiftness, as that of an express messenger; great haste, great hope, speed towards an end which promises assured felicity; generally, that which is on the move; also the arrows of love.;The card represents motion through the immovable-a flight of wands through an open country; but they draw to the term of their course. That which they signify is at hand; it may be even on the threshold.");
		tarotCardSet[8] = new TarotCard(50, "Ace of Pentacles", "pentacles",
						"완전한 만족과 행복, 빠른 지성, 금을 상징합니다. 구름에서 나오는 손이 펜타클을 들어올리는 모습으로 그려져 있습니다. 이 카드는 내적인 만족과 성공을 나타내며, 지적인 업적을 이루거나 물질적인 풍요를 상징합니다. 또한, 새로운 시작과 기회를 상징하며, 행운과 성공의 시작을 나타냅니다.",
						"Perfect contentment, felicity, ecstasy; also speedy intelligence; gold.;A hand--issuing, as usual, from a cloud--holds up a pentacle.");
		tarotCardSet[9] = new TarotCard(65, "Two of Swords", "swords",
						"순응과 균형, 용기, 우정, 군사적인 조화를 상징합니다. 또한, 애정, 애착, 친밀함과 같은 의미도 전할 수 있습니다. 그러나 검 카드는 일반적으로 인간 사회에서 긍정적인 힘을 상징하지 않기 때문에 조화와 유리한 해석은 조심스럽게 고려되어야 합니다. 카드에는 눈가리개를 쓴 여성이 어깨 위에 검을 균형있게 놓고 있는 모습이 그려져 있습니다.",
						"Conformity and the equipoise which it suggests, courage, friendship, concord in a state of arms; another reading gives tenderness, affection, intimacy. The suggestion of harmony and other favourable readings must be considered in a qualified manner, as Swords generally are not symbolical of beneficent forces in human affairs.;A hoodwinked female figure balances two swords upon her shoulders.");
	}

	public static TarotCardSetSingleton getInstance() {
		return standard;
	}

	public TarotCard getTarotCard(int index) {
		return tarotCardSet[index - 1];
	}
}