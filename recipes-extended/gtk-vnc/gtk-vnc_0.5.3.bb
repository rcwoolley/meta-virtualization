DESCRIPTION = "VNC viewer widget for GTK+2"
HOMEPAGE = "https://wiki.gnome.org/Projects/gtk-vnc"
LICENSE = "GPLv2+"

DEPENDS = "cyrus-sasl python-pygtk python-pygobject-native gtk+3 vala"
RDEPENDS_${PN} = "util-linux-libuuid libsndfile1 libxtst json-c libxi libgpg-error libcap \
            libpulse libpulsecommon libpulse-simple gnutls libgcrypt gmp nettle"
PR = "r0"

inherit autotools python-dir pythonnative pkgconfig

PACKAGES += "gvncviewer ${PN}-python ${PN}-python-dbg ${PN}-python-dev"

FILES_gvncviewer = "/usr/bin/gvnccapture /usr/bin/gvncviewer"
FILES_${PN} = "${libdir}/libgtk-vnc-*.so.* \
               ${libdir}/libgvnc-*.so.* \
               ${libdir}/libgvncpulse-*.so.*"

FILES_${PN}-python = "${libdir}/python2.7/site-packages/gtkvnc.so"
FILES_${PN}-python-dbg = "${libdir}/python2.7/site-packages/.debug/gtkvnc.so"
FILES_${PN}-python-dev = "${libdir}/python2.7/site-packages/gtkvnc.la"

LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=4339efb5fd592e45b9e2641de9fe734f"

SRC_URI = "https://download.gnome.org/sources/${PN}/0.5/${PN}-${PV}.tar.xz"
SRC_URI += "file://pygtk-codegen-fix.patch"
SRC_URI[md5sum] = "1dccd918a4d633020e4afaf6c9352cde"
SRC_URI[sha256sum] = "d490a6c8f40e550d43aef0043ce3bec498ec220d5eb3dc5cdcff8fd561149caf"

EXTRA_OECONF += "--with-gtk=3.0 --with-python --disable-introspection --with-examples"

do_configure_append() {
	sed -i \
	-e s:'$(shell pkg-config --variable=defsdir pygtk-2.0)':${STAGING_DATADIR}/pygtk/2.0/defs:g \
	-e s:'$(shell pkg-config --variable=codegendir pygtk-2.0)':${STAGING_DATADIR}/pygobject/2.0/codegen:g \
${S}/src/Makefile.am
}
