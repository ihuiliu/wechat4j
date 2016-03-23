package org.sword.wechat4j.common;


public class WechatUrl {
	//上传门店LOGO
	public static final String UPLOADHEAD_LOGO_POST_URL="https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";
	//创建卡券
	public static final String CREATE_CARD_POST_URL="https://api.weixin.qq.com/card/create?access_token=";
	//设置买单
	public static final String PAYCELL_SET_POST_URL="https://api.weixin.qq.com/card/paycell/set?access_token=";
	/* 创建会话*/
	public static final String CUSTOMSERVICE_KFSESSION_CREATE_POST_URL = "https://api.weixin.qq.com/customservice/kfsession/create?access_token=";
	/* 关闭会话*/
	public static final String CUSTOMSERVICE_KFSESSION_CLOSE_POST_URL = "https://api.weixin.qq.com/customservice/kfsession/close?access_token=";
	/* 获取客户的会话状态*/
	public static final String CUSTOMSERVICE_KFSESSION_GETSESSION_GET_URL = "https://api.weixin.qq.com/customservice/kfsession/getsession?access_token=";
	/* 获取客服的会话列表*/
	public static final String CUSTOMSERVICE_KFSESSION_GETSESSIONLIST_GET_URL = "https://api.weixin.qq.com/customservice/kfsession/getsessionlist?access_token=";
	/* 获取未接入会话列表*/
	public static final String CUSTOMSERVICE_KFSESSION_GETWAITCASE_GET_URL = "https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token=";
	/* 获取客服基本信息*/
	public static final String CUSTOMSERVICE_GETKFLIST_GET_URL = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=";
	/* 获取在线客服接待信息*/
	public static final String CUSTOMSERVICE_GETONLIEKFLIST_GET_URL = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=";
	/* 添加客服账号*/
	public static final String CUSTOMSERVICE_KFACCOUNT_ADD_POST_URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=";
	/* 设置客服信息*/
	public static final String CUSTOMSERVICE_KFACCOUNT_UPDATE_POST_URL = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=";
	/* 上传客服头像*/
	public static final String CUSTOMSERVICE_KFACCOUNT_UPLOADHEADIMG_POST_URL = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=";
	/* 删除客服账号*/
	public static final String CUSTOMSERVICE_KFACCOUNT_DEL_POST_URL = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=";
	// 获取客服聊天记录接口
	public static final String CUSTOMSERVICE_MSGRECORD_GETRECORD_POST_URL="https://api.weixin.qq.com/customservice/msgrecord/getrecord?access_token=";

	public static final String MENU_CREATE_POST_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	public static final String MENU_GET_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
	public static final String MENU_DEL_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
	//新增临时素材
	public static final String MEDIA_UPLOAD_TEMP ="https://api.weixin.qq.com/cgi-bin/media/upload?access_token=";
	//获取临时素材
	public static final String MEDIA_DOWNLOAD_TEMP ="https://api.weixin.qq.com/cgi-bin/media/get?access_token=";
	//新增永久图文素材
	public static final String MEDIA_UPLOAD_PERPETUAL_NEWS ="https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=";
	//上传图文消息内的图片 和上传卡券LOGO
	public static final String MEDIA_UPLOAD_PERPETUAL_NEWS_IMG ="https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";
	//新增永久其他素材
	public static final String MEDIA_UPLOAD_PERPETUAL_MATERIAL ="https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=";
	//获取永久素材
	public static final String MEDIA_DOWNLOAD_PERPETUAL="https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=";
	//删除永久素材
	public static final String MEDIA_DELETE_PERPETUAL="https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=";
	//修改永久图文素材
	public static final String MEDIA_UPDATE_NEWS="https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=";
	//获取素材总数
	public static final String MEDIA_COUNT="https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=";
	//获取素材列表
	public static final String MEDIA_BATH_GET="https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
	/* 上传图文消息素材【订阅号与服务号认证后均可用】*/
	public static final String UPLOADNEWS_MEDIA_POST_URL ="https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=";
	/* 视频消息*/
	public static final String UPLOADVIDEO_MEDIA_POST_URL ="https://api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=";
	/* 根据分组进行群发 */
	public static final String MESSAGE_MASS_SENDALL_POST_URL="https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=";
	/*根据OpenID列表群发【订阅号不可用，服务号认证后可用】*/
	public static final String MESSAGE_MASS_SEND_POST_URL ="https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=";
	/* 预览接口【订阅号与服务号认证后均可用】*/
	public static final String MESSAGE_MASS_PREVIEW_POST_URL="https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=";
	/* 删除群发【订阅号与服务号认证后均可用】 */
	public static final String MESSAGE_MASS_DELETE_POST_URL ="https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=";
	/* 查询群发消息发送状态【订阅号与服务号认证后均可用】 */
	public static final String MESSAGE_MASS_GET_POST_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=";
	public static final String CUSTOMSERVICE_MESSAGE_SEND_POST_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
	//设置所属行业接口地址
	public static final String SET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";
	//添加模板id接口地址
	public static final String GET_TEMPLATE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=";
	//发送模板消息接口地址
	public static final String SEND_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
	public static final String OAUTH2_AUTHORIZEURL="https://open.weixin.qq.com/connect/oauth2/authorize?";
	public static final String OAUTH2_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?";
	public static final String OAUTH2_REFRESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token?";
	public static final String USERINFO = "https://api.weixin.qq.com/sns/userinfo?";
	public static final String	AUTH_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/auth?";

	//----------------------------------------长链接转短链接接口-----------------------------------------------
	public static final String SHORTURL_POST_URL="https://api.weixin.qq.com/cgi-bin/shorturl?access_token=";
	//----------------------------------------生成带参数的二维码-----------------------------------------------
	public static final String QRCODE_POST_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
	public static final String SHOWQRCODE_POST_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
	//------------------------------------获取用户列表----------------------------------
	/**获取用户列表*/
	public static final String USRE_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=";
	//------------------------------------设置用户备注名-------------------------------------------
	/**设置用户备注名*/
	public static final String USER_UPDATE_REMARK_POST_URL="https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=";
	//------------------------------------获取用户基本信息-------------------------------
	/**获取用户基本信息*/
	public static final String USER_INFO_GET_URL="https://api.weixin.qq.com/cgi-bin/user/info?access_token=";
	/**批量获取用户基本信息*/
	public static final String USER_INFO_BATCHGET_GET_URL="https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=";
	//------------------------------------用户分组管理-------------------
	/**创建分组*/
	public static final String GROUP_CREATE_POST_URL="https://api.weixin.qq.com/cgi-bin/groups/create?access_token=";
	/**查询所有分组*/
	public static final String GROUP_GET_POST_URL="https://api.weixin.qq.com/cgi-bin/groups/get?access_token=";
	/**查询用户所在分组*/
	public static final String GROUP_GETID_POST_URL="https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=";
	/**修改分组名*/
	public static final String GROUP_UPDATE_POST_URL="https://api.weixin.qq.com/cgi-bin/groups/update?access_token=";
	/**移动用户分组*/
	public static final String GROUP_MEMBERS_UPDATE_POST_URL="https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=";
	/**批量移动用户分组*/
	public static final String GROUP_MEMBERS_DATCHUPDATE_POST_URL="https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=";
	/**删除分组*/
	public static final String GROUP_DELETE_POST_URL="https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=";
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
	//创建门店
	public static final String ADDPOI ="http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token=";
	//查询门店信息
	public static final String GETPOI ="http://api.weixin.qq.com/cgi-bin/poi/getpoi?access_token=";
	//查询门店列表
	public static final String GETPOILIST ="https://api.weixin.qq.com/cgi-bin/poi/getpoilist?access_token=";
	//修改门店服务信息
	public static final String UPDATEPOI ="https://api.weixin.qq.com/cgi-bin/poi/updatepoi?access_token=";
	//删除门店
	public static final String DELPOI ="https://api.weixin.qq.com/cgi-bin/poi/delpoi?access_token=";
	//统一下单
	public static final String PAY_UNIFIEDORDER ="https://api.mch.weixin.qq.com/pay/unifiedorder";
	//提交刷卡支付
	public static final String PAY_MICROPAY ="https://api.mch.weixin.qq.com/pay/micropay";
	//申请退款
	public static final String PAY_REFUND = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	//查询订单
	public static final String PAY_ORDERQUERY = "https://api.mch.weixin.qq.com/pay/orderquery";
	//查询退款
	public static final String PAY_REFUNDQUERY =  "https://api.mch.weixin.qq.com/pay/refundquery";
	//关闭订单
	public static final String PAY_CLOSEORDER = "https://api.mch.weixin.qq.com/pay/closeorder";
	//下载对账单
	public static final String PAY_DOWNLOADBILL="https://api.mch.weixin.qq.com/pay/downloadbill";
	public static final String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?";

	//生成卡券二维码
	public static final String QRCODE_CARD_CREATE = "https://api.weixin.qq.com/card/qrcode/create?access_token=";
	//创建货架接口  卡券投放
	public static final String CARD_LANGINGPAGE_CREATE="https://api.weixin.qq.com/card/landingpage/create?access_token=";
	//设置测试白名单
	public static final String CARD_TESTWHITELIST_SET ="https://api.weixin.qq.com/card/testwhitelist/set?access_token=";
	//查询Code接口
	public static final String CARD_CODE_GET="https://api.weixin.qq.com/card/code/get?access_token=";
	//核销code接口
	public static final String CARD_CODE_CONSUME = "https://api.weixin.qq.com/card/code/consume?access_token=";
	//Code解码接口
	public static final String CARD_CODE_DECRYPT = "https://api.weixin.qq.com/card/code/decrypt?access_token=";
	//获取用户已领取卡券接口
	public static final String CARD_USER_LIST="https://api.weixin.qq.com/card/user/getcardlist?access_token=";
	//查看卡券详情
	public static final String CARD_GET = "https://api.weixin.qq.com/card/get?access_token=";
	//批量查询卡列表
	public static final String CARD_BATCHGET = "https://api.weixin.qq.com/card/batchget?access_token=";
	//更改卡券信息接口
	public static final String CARD_UPDATE="https://api.weixin.qq.com/card/update?access_token=";
	//修改库存接口
	public static final String CARD_MODIFYS_TOCK="https://api.weixin.qq.com/card/modifystock?access_token=";
	//更改Code接口
	public static final String CARD_CODE_UPDATE="https://api.weixin.qq.com/card/code/update?access_token=";
	//删除卡券接口
	public static final String CARD_DELETE = "https://api.weixin.qq.com/card/delete?access_token=";
	//设置卡券失效
	public static final String CARD_CODE_UNAVAILABLE ="https://api.weixin.qq.com/card/code/unavailable?access_token=";
	//获取卡券背景颜色列表
	public static final String CARD_COLOR_LIST = "https://api.weixin.qq.com/card/getcolors?access_token=";
	//拉取卡券概况数据接口
	public static final String CARD_BIZUIN_INFO="https://api.weixin.qq.com/datacube/getcardbizuininfo?access_token=";
	//获取免费券数据接口
	public static final String CARD_CARD_INFO="https://api.weixin.qq.com/datacube/getcardcardinfo?access_token=";
	//拉取会员卡数据接口
	public static final String CARD_MEMBER_CARD_INFO="https://api.weixin.qq.com/datacube/getcardmembercardinfo?access_token=";
	//更新会议门票
	public static final String CARD_MEETING_TICKET = "https://api.weixin.qq.com/card/meetingticket/updateuser?access_token=";
	//更新电影票
	public static final String CARD_MOVIE_TICKET = "https://api.weixin.qq.com/card/movieticket/updateuser?access_token=";
	//更新飞机票
	public static final String CARD_BOARDING_PASS = "https://api.weixin.qq.com/card/boardingpass/checkin?access_token=";
	//接口激活
	public static final String CARD_MEMBER_ACTIVATE = "https://api.weixin.qq.com/card/membercard/activate?access_token=";
	//设置开卡字段接口
	public static final String CARD_MEMBER_ACTIVATE_USER_FORM = "https://api.weixin.qq.com/card/membercard/activateuserform/set?access_token=";
	//拉取会员信息
	public static final String CARD_MEMBER_USER_INFO = "https://api.weixin.qq.com/card/membercard/userinfo/get?access_token=";
	//获取WiFi门店列表
	public static final String BIZWIFI_SHOP_LIST = "https://api.weixin.qq.com/bizwifi/shop/list?access_token=";
	//查询门店的WiFi信息
	public static final String BIZWIFI_GET ="https://api.weixin.qq.com/bizwifi/shop/get?access_token=";
	//添加密码型设备
	public static final String BIZWIFI_ADD = "api.weixin.qq.com/bizwifi/device/add?access_token=";
	//查询设备
	public static final String BIZWIFI_DEVICE_LIST = "https://api.weixin.qq.com/bizwifi/device/list?access_token=";
	//删除设备
	public static final String BIZWIFI_DEVICE_DEL = "https://api.weixin.qq.com/bizwifi/device/delete?access_token=";
	//获取物料二维码
	public static final String BIZWIFI_QRCODE = "https://api.weixin.qq.com/bizwifi/qrcode/get?access_token=";
	//获取公众号连网URL
	public static final String BIZWIFI_CONNECT_URL = "https://api.weixin.qq.com/bizwifi/account/get_connecturl?access_token=";
	//设置商家主页
	public static final String BIZWIFI_HOMEPAGE_SET = "https://api.weixin.qq.com/bizwifi/homepage/set?access_token=";
	//查询商家主页
	public static final String BIZWIFI_HOMEPAGE_GET ="https://api.weixin.qq.com/bizwifi/homepage/get?access_token=";
	//设置顶部常驻入口文案
	public static final String BIZWIFI_BAR_SET="https://api.weixin.qq.com/bizwifi/bar/set?access_token=";
	//数据统计
	public static final String BIZWIFI_STATISTICS = "https://api.weixin.qq.com/bizwifi/statistics/list?access_token=";

}
