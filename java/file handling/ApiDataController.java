/**
 * @author sunl
 */
@RestController
@RequestMapping("/apiData")
public class ApiDataController {

	@Autowired
	private PricTaskDetailService pricTaskDetailService;

	@Value("${yun.filepath}")
	private String filepath;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	/**
	 * 文件复制并分类
	 */
	@AuthIgnore
	@GetMapping("/documentClassifcationAip")
	public String documentClassifcationAip() {
		logger.info("start pricSuccessfulFile" + new Date());
		String yearStr = DateUtils.year.format(new Date());
		String monthStr = DateUtils.month.format(new Date());
		String dayStr = DateUtils.day.format(new Date());
		String dateStr = yearStr + "-" + monthStr + "-" + dayStr;
		//查询文件的存放地址
		List<PricTaskDetailEntity> pricTaskDetailList = pricTaskDetailService.pricSuccessfulFile();
		File imageUrlArray[] = new File[pricTaskDetailList.size()];
		String baseFilePath = filepath + File.separator + "successdata" + File.separator + dateStr;
		File basePath = new File(baseFilePath);
		if (!basePath.exists()) {
			basePath.mkdirs();
		}
		if (pricTaskDetailList.size() > 0) {
			for (int i = 0; i < imageUrlArray.length; i++) {
				imageUrlArray[i] = new File(filepath + File.separator + pricTaskDetailList.get(i).getScanImages());
				String impageStr = imageUrlArray[i].toString();
				String impageName = impageStr.substring(impageStr.lastIndexOf(File.separator) + 1);
				File imagesbase = new File(basePath + File.separator + impageName);
				try {
					if (!imagesbase.exists()) {
						Files.copy(imageUrlArray[i].toPath(), imagesbase.toPath());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
		
		
		
	/**
	 * 根据文件类型，进行压缩下载
	 * 
	 * @param response
	 * @param files
	 */
	public void downloadBatchByFile(HttpServletResponse response, File imageArr[], String zipName,String fileType) {
		try {
				String basePath = filepath + File.separator;
				String yearStr = DateUtils.year.format(new Date());
				String monthStr = DateUtils.month.format(new Date());
				String dayStr = DateUtils.day.format(new Date());
				String dateStr = yearStr + "-" + monthStr + "-" + dayStr;
				String baseFilePath = basePath + fileType + File.separator + dateStr;
				response.setContentType("APPLICATION/OCTET-STREAM");  
				response.setHeader("Content-Disposition","attachment; filename="+zipName);
				ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
				try {
					for(int i = 0; i < imageArr.length; i++){
					ZipMultFileUtils.doCompress(baseFilePath, out);
					response.flushBuffer();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

	}
		
}