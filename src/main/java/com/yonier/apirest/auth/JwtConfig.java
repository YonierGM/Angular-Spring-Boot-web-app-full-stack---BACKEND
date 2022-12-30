package com.yonier.apirest.auth;

public class JwtConfig {

	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpAIBAAKCAQEA0qAm89oj/xbt8leXMNETOKqjW0y+GJP4X8MNVL/+K2NZxD4B\r\n"
			+ "Qy4Oi5LjhMz+3uS3tkJ6pVu5b7gDVpPLnfgPSeKGwOPD9xwv6qnE5PQN3LLtIWoF\r\n"
			+ "6onpNR/4Z2l1jxUJZNRyw9zBW6HqrMK9ePCBbjT9DxV86ojBG4esss2GZ0XVU6aH\r\n"
			+ "yh6Lur/mXEwomvaquLPI/yf8t+AN/gz0tJQpbsslrWve57JbBKg60DGczbSshEmt\r\n"
			+ "1xtcTMkn9VpEJy/gpe0Cu4wpt3ABD2fEdPlkaJVVm+kwDmnwB5hErheu8kJT2dGI\r\n"
			+ "Ucl4J70mGd3xG5gdUvOXej4w5Loyl+tjGljl6wIDAQABAoIBAQCMTbKk7cLcweFv\r\n"
			+ "dXl5Q0ySitiWkOBwbuEcqUnQErS1IlFBsCwXHC8EOqzkYcnFoIXgGxin3hoAmYtf\r\n"
			+ "uMQCTqOgjA1HoHGBwn0IzF4kRY6WXXoor/+Q5J08jjdia5Wr4k+Hox1v6zXCXHF+\r\n"
			+ "85pTXaJaT2HjEmVLth0swYwA73eAgobPCqK+pY9oAZetuufwo0NQJElQ2zecMtN+\r\n"
			+ "PlBqr8BOFUzKojTFUBzsd9l1L8UMIEOk1xwM6gL+ntLakH1TBxlU2qFtpollLHn7\r\n"
			+ "4dczsrissnhCY2FMXLR+aXuiBc9sDc8fKyVcoUIiGcFf6aFCNvZggxuJ2sS87h8x\r\n"
			+ "R7lQ3k3BAoGBAO2BupM7mzX5axyaLkvTHv6aXdAPTLxZ3GkOElH6mL7+l57sn9oZ\r\n"
			+ "EF5dxRmtzt1gxBjFXNW5XONO33cpyj5DNWxkK8WKiHGBSi0NoknRQHxnABPWLLUa\r\n"
			+ "vsoVCHuD7XcpSxUAdVa/FR+P0hIgjgVTV4O9v/2tEuQgbwwsyfim2UnFAoGBAOMG\r\n"
			+ "mHzsSe0DtMW6UGaKgmjfkdLoavDavVMdwTkTBT/y0aaPW3rXVG2K8ktTZtzpFdOo\r\n"
			+ "QBuxb2EQGqiHzT5+MyU7xhTAYOSRl5hhHxw4PDAdGiFT2+PNWlxA6rySWTcqCx4f\r\n"
			+ "PvzYVI797fdY/tmOyJhRu6tdSx1XHK7LuqmvdFvvAoGACDrpmzaCj2FAO/J/zjLX\r\n"
			+ "rRzuSUpub0xx3dYV/m8/ocayvFgYxfb+YTbAoL4sH/G9edpE+Eb/GAVgqwFwt62e\r\n"
			+ "iU4DUkoVplFDn8IMMKCmqmjrUMSoMfJmUBxged89eFae+nBUoJfohHp4XhZwtXCI\r\n"
			+ "5NDLeV/o+qzBDFv097/YYb0CgYEAz8P0f7cbPJ68rIwDEqTGDkY0xSjQ3dXBmDRN\r\n"
			+ "5fbDQi/tsBnYZYZ1DL8xWMBeDeP+hrKe4Pk0bkb3rq6BpiSGmBepAsrAoc2gR+Ly\r\n"
			+ "Prg0VO/9Puzo+wSvImiCqsrgfPysKgf8dBdi423+fvRiXyYt7EA4mO6LVLGpXUqz\r\n"
			+ "bKFWwt8CgYBMo0g9TUDWedGA6nhv6yi75n8W302kzi/Kttme2cVFnu5/O4gkGxBL\r\n"
			+ "Nk23PFq5gCJ8dHM/rJgqkxnkz6mnsoRAvd4v77TdwO2bAhbdjT8Hymy0IMVRhniI\r\n"
			+ "37LDwxGaIAOQ6PA1mtGGjGUzz7tKzqX61913SqF6oZOi607lllAl3A==\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0qAm89oj/xbt8leXMNET\r\n"
			+ "OKqjW0y+GJP4X8MNVL/+K2NZxD4BQy4Oi5LjhMz+3uS3tkJ6pVu5b7gDVpPLnfgP\r\n"
			+ "SeKGwOPD9xwv6qnE5PQN3LLtIWoF6onpNR/4Z2l1jxUJZNRyw9zBW6HqrMK9ePCB\r\n"
			+ "bjT9DxV86ojBG4esss2GZ0XVU6aHyh6Lur/mXEwomvaquLPI/yf8t+AN/gz0tJQp\r\n"
			+ "bsslrWve57JbBKg60DGczbSshEmt1xtcTMkn9VpEJy/gpe0Cu4wpt3ABD2fEdPlk\r\n"
			+ "aJVVm+kwDmnwB5hErheu8kJT2dGIUcl4J70mGd3xG5gdUvOXej4w5Loyl+tjGljl\r\n"
			+ "6wIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}
